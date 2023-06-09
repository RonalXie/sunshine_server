package com.ronalxie.controller;

import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.RespBean;
import com.ronalxie.model.tag.dto.TagHandleDto;
import com.ronalxie.model.tag.dto.TagSearchDto;
import com.ronalxie.model.tag.vo.TagBaseVo;
import com.ronalxie.service.TagService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @RequestMapping(value = "/searchList",method = RequestMethod.POST)
    public RespBean searchList(PageParam pageParam, @RequestBody(required = false) TagSearchDto tagSearchDto){
        List<TagBaseVo> tagBaseVoList=tagService.searchList(tagSearchDto);
        return RespBean.success("标签列表",tagBaseVoList);
    }

    @RequestMapping(value = "/searchPage", method = RequestMethod.POST)
    public RespBean searchPage(PageParam pageParam, @RequestBody(required = false) TagSearchDto tagSearchDto){
        PageBean<TagBaseVo> pageBean=tagService.searchPage(pageParam,tagSearchDto);
        return RespBean.success("标签列表",pageBean);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody TagHandleDto tagHandleDto){
        tagService.save(tagHandleDto);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody TagHandleDto tagHandleDto){
        tagService.update(tagHandleDto);
    }


}
