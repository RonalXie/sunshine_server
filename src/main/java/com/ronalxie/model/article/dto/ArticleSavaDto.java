package com.ronalxie.model.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSavaDto {

    private String title;

    private String summary;

    private String cover;

    private Boolean top;

    private String content;

    private Long categoryId;

    private Long userId;

    private Long tagIds[];

}
