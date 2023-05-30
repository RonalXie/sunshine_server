package com.ronalxie.service.impl;

import com.github.pagehelper.PageHelper;
import com.ronalxie.mapper.TagMapper;
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
    public List<TagBaseVo> searchList(PageParam pageParam, TagSearchDto tagSearchDto) {
        TagEntity tagEntity=new TagEntity();
        if (!ObjectUtils.isEmpty(tagSearchDto)){
            BeanUtils.copyProperties(tagSearchDto,tagEntity);
        }
        if (pageParam.getPageSize()!=0){
            int pageSize=pageParam.getPageSize();
            int pageNum=pageParam.getPageNum();
            PageHelper.startPage(pageNum,pageSize);
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
}
