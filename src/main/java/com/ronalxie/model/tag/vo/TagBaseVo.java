package com.ronalxie.model.tag.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}