package com.ronalxie.mapper;

import com.ronalxie.model.ArticleEntity;

public interface ArticleEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleEntity record);

    int insertSelective(ArticleEntity record);

    ArticleEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleEntity record);

    int updateByPrimaryKey(ArticleEntity record);
}