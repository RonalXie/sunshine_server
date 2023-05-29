package com.ronalxie.service;

import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.article.dto.ArticleSearchDto;
import com.ronalxie.model.article.vo.ArticlePageVo;

public interface ArticleService {

    public PageBean<ArticlePageVo> searchPageInfo(PageParam pageParam, ArticleSearchDto articleSearchDto);
}
