package com.ronalxie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ronalxie.mapper.AttachmentMapper;
import com.ronalxie.model.PageBean;
import com.ronalxie.model.PageParam;
import com.ronalxie.model.article.ArticleInfoEntity;
import com.ronalxie.model.article.vo.ArticlePageVo;
import com.ronalxie.model.attachment.AttachmentEntity;
import com.ronalxie.model.attachment.dto.AttachmentSearchDto;
import com.ronalxie.model.attachment.vo.AttachmentVo;
import com.ronalxie.service.AttachmentService;
import com.ronalxie.util.BeanCopyUtils;
import com.ronalxie.util.IDUtils;
import com.ronalxie.util.MinioUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Resource
    private AttachmentMapper attachmentMapper;

    @Resource
    private MinioUtils minioUtils;

    @Override
    public void upload(MultipartFile multipartFile) {
        try {
            AttachmentEntity upload = minioUtils.upload(multipartFile);
            upload.setId(IDUtils.nextId());
            attachmentMapper.insert(upload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageBean<AttachmentVo> selectPageList(PageParam pageParam, AttachmentSearchDto attachmentSearchDto){
        AttachmentEntity attachment=new AttachmentEntity();
        if (!ObjectUtils.isEmpty(attachmentSearchDto)){
            attachment = BeanCopyUtils.copyBean(attachmentSearchDto, AttachmentEntity.class);
        }
        int pageSize=pageParam.getPageSize();
        int pageNum = pageParam.getPageNum();
        PageHelper.startPage(pageNum,pageSize);
        List<AttachmentEntity> attachmentEntities = attachmentMapper.selectAllList(attachment);

        PageInfo<AttachmentEntity> pageInfo=new PageInfo<>(attachmentEntities);
        //封装分页参数
        List<AttachmentVo> attachmentVoList=new ArrayList<>();
        attachmentEntities.forEach(item->{
            AttachmentVo attachmentVo = BeanCopyUtils.copyBean(item, AttachmentVo.class);
            attachmentVoList.add(attachmentVo);
        });
        PageBean<AttachmentVo> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setPageNum(pageNum);
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setDataList(attachmentVoList);
        return pageBean;
    }

    @Override
    public void batchUpload(MultipartFile[] files) {
        for (MultipartFile file : files) {
            this.upload(file);
        }
    }
}
