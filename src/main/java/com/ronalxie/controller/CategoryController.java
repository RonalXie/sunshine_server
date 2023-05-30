package com.ronalxie.controller;

import com.ronalxie.model.PageParam;
import com.ronalxie.model.RespBean;
import com.ronalxie.model.category.dto.CategorySearchDto;
import com.ronalxie.model.category.vo.CategoryBaseVo;
import com.ronalxie.service.CategoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;


    @RequestMapping(value = "searchList",method = RequestMethod.POST)
    public RespBean searchList(PageParam pageParam, @RequestBody(required = false) CategorySearchDto categorySearchDto){
        List<CategoryBaseVo> categoryBaseVoList=categoryService.seachList(pageParam,categorySearchDto);
        return RespBean.success("分类列表",categoryBaseVoList);
    }


}
