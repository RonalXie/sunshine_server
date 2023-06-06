package com.ronalxie.mapper;

import com.ronalxie.model.attachment.AttachmentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AttachmentEntity record);

    int insertSelective(AttachmentEntity record);

    AttachmentEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AttachmentEntity record);

    int updateByPrimaryKey(AttachmentEntity record);
}