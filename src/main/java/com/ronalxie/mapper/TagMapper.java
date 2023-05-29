package com.ronalxie.mapper;

import com.ronalxie.model.tag.TagEntity;

public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TagEntity record);

    int insertSelective(TagEntity record);

    TagEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagEntity record);

    int updateByPrimaryKey(TagEntity record);
}