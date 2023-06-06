package com.ronalxie.service;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    public Long upload(MultipartFile multipartFile);
}
