package com.ronalxie.service;


import com.ronalxie.model.PageParam;
import com.ronalxie.model.tag.dto.TagSearchDto;
import com.ronalxie.model.tag.vo.TagBaseVo;

import java.util.List;

public interface TagService {
    List<TagBaseVo> searchList(PageParam pageParam, TagSearchDto tagSearchDto);
}
