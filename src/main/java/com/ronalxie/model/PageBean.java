package com.ronalxie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {

    private int pageSize;
    private int pageNum;
    private long total;
    private List<T> dataList;

}
