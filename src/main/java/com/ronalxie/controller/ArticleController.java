package com.ronalxie.controller;


import com.ronalxie.model.PageParam;
import com.ronalxie.model.RespBean;
import com.ronalxie.model.article.dto.ArticleSearchDto;
import com.ronalxie.service.ArticleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;


    @RequestMapping(value = "/searchPageInfo",method = RequestMethod.POST)
    public RespBean searchPageInfo(PageParam pageParam, @RequestBody(required = false) ArticleSearchDto articleSearchDto){

        return RespBean.success("文章列表",articleService.searchPageInfo(pageParam,articleSearchDto));

    }



}
