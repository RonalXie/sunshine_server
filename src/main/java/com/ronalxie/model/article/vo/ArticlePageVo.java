package com.ronalxie.model.article.vo;

import com.ronalxie.model.category.CategoryEntity;
import com.ronalxie.model.tag.TagEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlePageVo {
    private Long id;

    private String title;

    private String abs;

    private String cover;

    private Integer views;

    private Boolean top;

    private CategoryEntity category;

    private List<TagEntity> tags;

    private Date createTime;



}