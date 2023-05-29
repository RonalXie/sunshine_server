package com.ronalxie.model.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSearchDto {

    private String title;

    private Boolean top;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;


}