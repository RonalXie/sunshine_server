package com.ronalxie.controller;

import com.ronalxie.service.AttachmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Resource
    private AttachmentService attachmentService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Long upload(@RequestParam("file") MultipartFile file){
        return attachmentService.upload(file);
    }
}
