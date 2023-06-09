package com.ronalxie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ronalxie.mapper.ArticleMapper;
import com.ronalxie.mapper.AttachmentMapper;
import com.ronalxie.mapper.CategoryMapper;
import com.ronalxie.mapper.TagMapper;
import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.article.ArticleBaseEntity;
import com.ronalxie.model.article.ArticleInfoEntity;
import com.ronalxie.model.article.dto.ArticleSavaDto;
import com.ronalxie.model.article.dto.ArticleSearchDto;
import com.ronalxie.model.article.dto.ArticleUpdateDto;
import com.ronalxie.model.article.vo.ArticleBaseVo;
import com.ronalxie.model.article.vo.ArticleInfoVo;
import com.ronalxie.model.article.vo.ArticlePageVo;
import com.ronalxie.model.attachment.AttachmentEntity;
import com.ronalxie.model.category.CategoryEntity;
import com.ronalxie.service.ArticleService;
import com.ronalxie.util.BeanCopyUtils;
import com.ronalxie.util.IDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private TagMapper tagMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private AttachmentMapper attachmentMapper;

    @Override
    public PageBean<ArticlePageVo> searchPageInfo(PageParam pageParam, ArticleSearchDto articleSearchDto) {
        int pageNum=pageParam.getPageNum();
        int pageSize=pageParam.getPageSize();
        ArticleBaseEntity articleBaseEntity=new ArticleBaseEntity();
        if (!ObjectUtils.isEmpty(articleSearchDto)){
            BeanUtils.copyProperties(articleSearchDto,articleBaseEntity);
        }
        //开始分页
        PageHelper.startPage(pageNum,pageSize).setOrderBy("create_time desc");
        List<ArticleInfoEntity> articleInfoEntities = articleMapper.selectAllInfo(articleBaseEntity);
        PageInfo<ArticleInfoEntity> pageInfo=new PageInfo<>(articleInfoEntities);
        //封装分页参数
        List<ArticlePageVo> articlePageVoList=new ArrayList<>();
        //查询分类
        articleInfoEntities = articleInfoEntities.stream().map((item) -> {
            item.setCategory(categoryMapper.selectByPrimaryKey(item.getCategoryId()));
            return item;
        }).collect(Collectors.toList());
        //查询标签
        articleInfoEntities=articleInfoEntities.stream().map(item->{
            item.setTags(tagMapper.selectByArticleId(item.getId()));
            return item;
        }).collect(Collectors.toList());
//        BeanUtils.copyProperties(articleInfoEntities,articlePageVoList);
        articleInfoEntities.forEach(item->{
            ArticlePageVo articlePageVo=new ArticlePageVo();
            articlePageVo.setId(item.getId());
            articlePageVo.setCategory(item.getCategory());
            articlePageVo.setTitle(item.getTitle());
            articlePageVo.setTags(item.getTags());
            articlePageVo.setCover(item.getCover());
            articlePageVo.setViews(item.getViews());
            articlePageVo.setCreateTime(item.getCreateTime());
            articlePageVo.setTop(item.getTop());
            articlePageVo.setSummary(item.getSummary());
            articlePageVoList.add(articlePageVo);
        });
        PageBean<ArticlePageVo> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setPageNum(pageNum);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setDataList(articlePageVoList);
        return pageBean;
    }

    @Override
    public List<ArticleBaseVo> searchBaseSort(String sort, ArticleSearchDto articleSearchDto) {
        ArticleBaseEntity articleBaseEntity=new ArticleBaseEntity();
        if (!ObjectUtils.isEmpty(articleSearchDto)){
            BeanUtils.copyProperties(articleSearchDto,articleBaseEntity);
        }
        PageHelper.startPage(1,10).setOrderBy(sort);
        List<ArticleInfoEntity> articleInfoEntities = articleMapper.selectAllInfo(articleBaseEntity);

        List<ArticleBaseVo> articleBaseVos=new ArrayList<>();
        articleInfoEntities.forEach(item->{
            ArticleBaseVo articleBaseVo=new ArticleBaseVo();
            articleBaseVo.setId(item.getId());
            articleBaseVo.setTitle(item.getTitle());
            articleBaseVo.setCover(item.getCover());
            articleBaseVo.setCreateTime(item.getCreateTime());
            articleBaseVo.setTop(item.getTop());
            articleBaseVos.add(articleBaseVo);
        });
        return articleBaseVos;
    }

    @Override
    public ArticleInfoVo searchArticleInfo(ArticleSearchDto articleSearchDto) {
        ArticleBaseEntity articleBaseEntity=new ArticleBaseEntity();
        if (!ObjectUtils.isEmpty(articleSearchDto)){
            BeanUtils.copyProperties(articleSearchDto,articleBaseEntity);
        }
        List<ArticleInfoEntity> articleInfoEntities = articleMapper.selectAllInfo(articleBaseEntity);
        if (ObjectUtils.isEmpty(articleInfoEntities)) {
            return null;
        }
        ArticleInfoEntity articleInfoEntity = articleInfoEntities.get(0);

        ArticleInfoVo articleInfoVo=new ArticleInfoVo();
        BeanUtils.copyProperties(articleInfoEntity,articleInfoVo);

        articleInfoVo.setCategory(categoryMapper.selectByPrimaryKey(articleInfoEntity.getCategoryId()));
        articleInfoVo.setTags(tagMapper.selectByArticleId(articleInfoVo.getId()));

        return articleInfoVo;
    }

    @Override
    @Transactional
    public void save(ArticleSavaDto articleSavaDto) {
        //保存文章基本信息
        ArticleBaseEntity articleBaseEntity = BeanCopyUtils.copyBean(articleSavaDto, ArticleBaseEntity.class);
        Long id=IDUtils.nextId();
        articleBaseEntity.setId(id);
        articleBaseEntity.setCreateTime(new Date());
        articleMapper.insertSelective(articleBaseEntity);
        //保存内容
        Map<String,Object> contentMap=new HashMap<>();
        contentMap.put("articleId",id);
        contentMap.put("content",articleSavaDto.getContent());
        articleMapper.insertContent(contentMap);
        //保存标签
        Long[] tagIds = articleSavaDto.getTagIds();
        Map<String,Long> articleRefTag=new HashMap<>();
        for (Long tagId : tagIds) {
            articleRefTag.put("articleId",id);
            articleRefTag.put("tagId",tagId);
            articleMapper.insertArticleTag(articleRefTag);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        //删除文章
        articleMapper.deleteByPrimaryKey(id);
        //删除内容
        articleMapper.deleteContent(id);
        //删除标签关联关系
        articleMapper.deleteArticleTag(id);
    }

    @Override
    public String searchContent(Long id) {
        return articleMapper.searchContent(id);
    }

    @Override
    @Transactional
    public void update(ArticleUpdateDto articleUpdateDto) {
        //更新文章表
        ArticleBaseEntity articleBaseEntity = BeanCopyUtils.copyBean(articleUpdateDto, ArticleBaseEntity.class);
        articleBaseEntity.setUpdateTime(new Date());
        articleMapper.updateByPrimaryKeySelective(articleBaseEntity);
        //更新内容表
        Map<String,Object> map=new HashMap<>();
        map.put("articleId",articleUpdateDto.getId());
        map.put("content",articleUpdateDto.getContent());
        articleMapper.updateContent(map);
        //更新标签关联表
        articleMapper.deleteArticleTag(articleUpdateDto.getId());
        Long[] tagIds = articleUpdateDto.getTagIds();
        Map<String,Long> articleRefTag=new HashMap<>();
        for (Long tagId : tagIds) {
            articleRefTag.put("articleId",articleUpdateDto.getId());
            articleRefTag.put("tagId",tagId);
            articleMapper.insertArticleTag(articleRefTag);
        }
    }
}
