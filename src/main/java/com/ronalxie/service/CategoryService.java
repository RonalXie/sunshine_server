package com.ronalxie.service;

import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.category.dto.CategorySearchDto;
import com.ronalxie.model.category.vo.CategoryBaseVo;

import java.util.List;

public interface CategoryService {
    List<CategoryBaseVo> searchList(CategorySearchDto categorySearchDto);
    PageBean<CategoryBaseVo> searchPage(PageParam pageParam, CategorySearchDto categorySearchDto);
}
