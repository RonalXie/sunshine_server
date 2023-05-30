package com.ronalxie.mapper;

import com.ronalxie.model.category.CategoryEntity;
import com.ronalxie.model.category.dto.CategorySearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CategoryEntity record);

    int insertSelective(CategoryEntity record);

    CategoryEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryEntity record);

    int updateByPrimaryKey(CategoryEntity record);

    List<CategoryEntity> searchList(CategoryEntity categoryEntity);
}