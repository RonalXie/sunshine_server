package com.ronalxie.controller;


import com.ronalxie.model.PageParam;
import com.ronalxie.model.RespBean;
import com.ronalxie.model.article.dto.ArticleSavaDto;
import com.ronalxie.model.article.dto.ArticleSearchDto;
import com.ronalxie.model.article.vo.ArticleBaseVo;
import com.ronalxie.service.ArticleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;


    @RequestMapping(value = "/searchPageInfo",method = RequestMethod.POST)
    public RespBean searchPageInfo(PageParam pageParam, @RequestBody(required = false) ArticleSearchDto articleSearchDto){

        return RespBean.success("文章列表",articleService.searchPageInfo(pageParam,articleSearchDto));

    }

    @RequestMapping(value = "/searchArticleInfo",method = RequestMethod.POST)
    public RespBean searchArticleInfo(@RequestBody ArticleSearchDto articleSearchDto){

        return RespBean.success("文章列表",articleService.searchArticleInfo(articleSearchDto));

    }

    @RequestMapping(value = "/searchBase",method = RequestMethod.POST)
    public RespBean searchBaseSort(String sort,@RequestBody(required = false) ArticleSearchDto articleSearchDto){
        List<ArticleBaseVo> articleBaseVoList= articleService.searchBaseSort(sort,articleSearchDto);
        return RespBean.success("文章列表",articleBaseVoList);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RespBean save(@RequestBody ArticleSavaDto articleSavaDto){
        articleService.save(articleSavaDto);
        return RespBean.success("保存成功");
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public void delete(Long id){
        articleService.delete(id);
    }


}
