package com.ronalxie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ronalxie.mapper.TagMapper;
import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.category.CategoryEntity;
import com.ronalxie.model.category.vo.CategoryBaseVo;
import com.ronalxie.model.tag.TagEntity;
import com.ronalxie.model.tag.dto.TagSearchDto;
import com.ronalxie.model.tag.vo.TagBaseVo;
import com.ronalxie.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public List<TagBaseVo> searchList(TagSearchDto tagSearchDto) {
        TagEntity tagEntity=new TagEntity();
        if (!ObjectUtils.isEmpty(tagSearchDto)){
            BeanUtils.copyProperties(tagSearchDto,tagEntity);
        }
        List<TagEntity> tagEntities=tagMapper.searchList(tagEntity);
        List<TagBaseVo> tagBaseVoList=new ArrayList<>();
        tagEntities.forEach(item->{
            TagBaseVo tagBaseVo=new TagBaseVo();
            BeanUtils.copyProperties(item,tagBaseVo);
            tagBaseVoList.add(tagBaseVo);
        });
        return tagBaseVoList;
    }

    @Override
    public PageBean<TagBaseVo> searchPage(PageParam pageParam, TagSearchDto tagSearchDto) {
        TagEntity tagEntity=new TagEntity();
        if (!ObjectUtils.isEmpty(tagSearchDto)){
            BeanUtils.copyProperties(tagSearchDto,tagEntity);
        }
        int pageSize=pageParam.getPageSize();
        int pageNum=pageParam.getPageNum();
        PageHelper.startPage(pageNum,pageSize);
        List<TagEntity> tagEntities=tagMapper.searchList(tagEntity);
        PageInfo<TagEntity> pageInfo=new PageInfo<>(tagEntities);
        List<TagBaseVo> tagBaseVoList=new ArrayList<>();
        tagEntities.forEach(item->{
            TagBaseVo tagBaseVo=new TagBaseVo();
            BeanUtils.copyProperties(item,tagBaseVo);
            tagBaseVoList.add(tagBaseVo);

        });
        PageBean<TagBaseVo> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setPageNum(pageNum);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setDataList(tagBaseVoList);
        return pageBean;
    }
}
