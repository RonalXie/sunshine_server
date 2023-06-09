package com.ronalxie.controller;

import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.RespBean;
import com.ronalxie.model.category.dto.CategoryHandleDto;
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
    public RespBean searchList(@RequestBody(required = false) CategorySearchDto categorySearchDto){
        List<CategoryBaseVo> categoryBaseVoList=categoryService.searchList(categorySearchDto);
        return RespBean.success("分类列表",categoryBaseVoList);
    }
    @RequestMapping(value = "searchPage",method = RequestMethod.POST)
    public RespBean searchPage(PageParam pageParam, @RequestBody(required = false) CategorySearchDto categorySearchDto){
        PageBean<CategoryBaseVo> pageBean = categoryService.searchPage(pageParam,categorySearchDto);
        return RespBean.success("分类列表",pageBean);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody CategoryHandleDto categoryHandleDto){
        categoryService.save(categoryHandleDto);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody CategoryHandleDto categoryHandleDto){
        categoryService.update(categoryHandleDto);
    }




}
