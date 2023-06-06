package com.ronalxie.service.impl;

import com.ronalxie.mapper.AttachmentMapper;
import com.ronalxie.model.attachment.AttachmentEntity;
import com.ronalxie.service.AttachmentService;
import com.ronalxie.util.IDUtils;
import com.ronalxie.util.MinioUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Resource
    private AttachmentMapper attachmentMapper;

    @Resource
    private MinioUtils minioUtils;

    @Override
    public Long upload(MultipartFile multipartFile) {
        try {
            AttachmentEntity upload = minioUtils.upload(multipartFile);
            upload.setId(IDUtils.nextId());
            attachmentMapper.insert(upload);
            return upload.getId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
