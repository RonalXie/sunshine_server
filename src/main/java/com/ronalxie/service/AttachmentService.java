package com.ronalxie.service;

import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.attachment.dto.AttachmentSearchDto;
import com.ronalxie.model.attachment.vo.AttachmentVo;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    public void upload(MultipartFile multipartFile);

    public PageBean<AttachmentVo> selectPageList(PageParam pageParam, AttachmentSearchDto attachmentSearchDto);

    void batchUpload(MultipartFile[] files);
}
