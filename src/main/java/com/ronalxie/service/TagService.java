package com.ronalxie.service;


import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.tag.dto.TagHandleDto;
import com.ronalxie.model.tag.dto.TagSearchDto;
import com.ronalxie.model.tag.vo.TagBaseVo;

import java.util.List;

public interface TagService {
    List<TagBaseVo> searchList( TagSearchDto tagSearchDto);
    PageBean<TagBaseVo> searchPage(PageParam pageParam, TagSearchDto tagSearchDto);

    void save(TagHandleDto tagHandleDto);

    void update(TagHandleDto tagHandleDto);
}
