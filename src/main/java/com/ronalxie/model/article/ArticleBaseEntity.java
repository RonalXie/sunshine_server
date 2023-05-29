package com.ronalxie.model.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleBaseEntity {
    private Long id;

    private String title;

    private String abs;

    private Long contentId;

    private String cover;

    private Integer views;

    private Boolean top;

    private Long categoryId;

    private Long userId;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;


}