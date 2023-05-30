package com.ronalxie.controller;

import com.ronalxie.model.PageParam;
import com.ronalxie.model.RespBean;
import com.ronalxie.model.tag.dto.TagSearchDto;
import com.ronalxie.model.tag.vo.TagBaseVo;
import com.ronalxie.service.TagService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @RequestMapping("/searchList")
    public RespBean searchList(PageParam pageParam, @RequestBody(required = false) TagSearchDto tagSearchDto){
        List<TagBaseVo> tagBaseVoList=tagService.searchList(pageParam,tagSearchDto);
        return RespBean.success("标签列表",tagBaseVoList);
    }


}
