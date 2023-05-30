package com.ronalxie.mapper;

import com.ronalxie.model.tag.TagEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TagEntity record);

    int insertSelective(TagEntity record);

    TagEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagEntity record);

    int updateByPrimaryKey(TagEntity record);

    List<TagEntity> selectByArticleId(Long articleId);

    List<TagEntity> searchList(TagEntity tagEntity);
}