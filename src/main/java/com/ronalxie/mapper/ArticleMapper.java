package com.ronalxie.mapper;

import com.ronalxie.model.article.ArticleBaseEntity;
import com.ronalxie.model.article.ArticleInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleBaseEntity record);

    int insertSelective(ArticleBaseEntity record);

    ArticleBaseEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleBaseEntity record);

    int updateByPrimaryKey(ArticleBaseEntity record);

    List<ArticleInfoEntity> selectAllInfo(ArticleBaseEntity articleBaseEntity);

    void insertContent(Map<String,Object> contentMap);


    void insertArticleTag(Map<String, Long> articleRefTag);
}