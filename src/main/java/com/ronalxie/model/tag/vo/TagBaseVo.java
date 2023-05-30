package com.ronalxie.model.tag.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagBaseVo {
    private Long id;

    private String name;

    private Integer count;

    private Date createTime;

}