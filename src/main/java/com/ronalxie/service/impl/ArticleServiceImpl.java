package com.ronalxie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ronalxie.mapper.ArticleMapper;
import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.article.ArticleBaseEntity;
import com.ronalxie.model.article.ArticleInfoEntity;
import com.ronalxie.model.article.dto.ArticleSearchDto;
import com.ronalxie.model.article.vo.ArticlePageVo;
import com.ronalxie.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;


    @Override
    public PageBean<ArticlePageVo> searchPageInfo(PageParam pageParam, ArticleSearchDto articleSearchDto) {
        int pageNum=pageParam.getPageNum();
        int pageSize=pageParam.getPageSize();
        ArticleBaseEntity articleBaseEntity=new ArticleBaseEntity();
        if (!ObjectUtils.isEmpty(articleSearchDto)){
            BeanUtils.copyProperties(articleSearchDto,articleBaseEntity);
        }
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleInfoEntity> articleInfoEntities = articleMapper.selectAllInfo(articleBaseEntity);
        PageInfo<ArticleInfoEntity> pageInfo=new PageInfo<>(articleInfoEntities);
        //封装分页参数
        List<ArticlePageVo> articlePageVoList=new ArrayList<>();
        BeanUtils.copyProperties(articleInfoEntities,articlePageVoList);
        PageBean<ArticlePageVo> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setPageNum(pageNum);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setDataList(articlePageVoList);
        return pageBean;
    }
}
