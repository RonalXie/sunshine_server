package com.ronalxie.model.category.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryHandleDto {
    private Long id;

    private String name;

    private Integer count;

}