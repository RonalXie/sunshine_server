package com.ronalxie.controller;

import com.github.pagehelper.Page;
import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.RespBean;
import com.ronalxie.model.attachment.dto.AttachmentSearchDto;
import com.ronalxie.model.attachment.vo.AttachmentVo;
import com.ronalxie.service.AttachmentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Resource
    private AttachmentService attachmentService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Long upload(@RequestPart("file") MultipartFile files[]){
//        return attachmentService.upload(file);
        attachmentService.batchUpload(files);
        System.out.println(1);
        return null;
    }

    @RequestMapping(value = "/searchPage",method = RequestMethod.POST)
    public RespBean searchPage(PageParam pageParam, @RequestBody(required = false) AttachmentSearchDto attachmentSearchDto){
        PageBean<AttachmentVo> attachmentVoPageBean = attachmentService.selectPageList(pageParam, attachmentSearchDto);
        return RespBean.success("附件列表",attachmentVoPageBean);
    }
}
