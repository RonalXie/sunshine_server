package com.ronalxie.service;

import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.article.dto.ArticleSearchDto;
import com.ronalxie.model.article.vo.ArticleBaseVo;
import com.ronalxie.model.article.vo.ArticleInfoVo;
import com.ronalxie.model.article.vo.ArticlePageVo;

import java.util.List;

public interface ArticleService {

    public PageBean<ArticlePageVo> searchPageInfo(PageParam pageParam, ArticleSearchDto articleSearchDto);

    List<ArticleBaseVo> searchBaseSort(String sort, ArticleSearchDto articleSearchDto);

    ArticleInfoVo searchArticleInfo(ArticleSearchDto articleSearchDto);
}
