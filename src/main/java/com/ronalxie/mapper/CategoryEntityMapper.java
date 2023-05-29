package com.ronalxie.mapper;

import com.ronalxie.model.category.CategoryEntity;

public interface CategoryEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CategoryEntity record);

    int insertSelective(CategoryEntity record);

    CategoryEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryEntity record);

    int updateByPrimaryKey(CategoryEntity record);
}