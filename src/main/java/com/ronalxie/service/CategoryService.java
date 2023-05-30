package com.ronalxie.service;

import com.ronalxie.model.PageParam;
import com.ronalxie.model.category.dto.CategorySearchDto;
import com.ronalxie.model.category.vo.CategoryBaseVo;

import java.util.List;

public interface CategoryService {
    List<CategoryBaseVo> seachList(PageParam pageParam, CategorySearchDto categorySearchDto);
}
