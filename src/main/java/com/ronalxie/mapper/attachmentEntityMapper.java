package com.ronalxie.mapper;

import com.ronalxie.model.attachmentEntity;

public interface attachmentEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(attachmentEntity record);

    int insertSelective(attachmentEntity record);

    attachmentEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(attachmentEntity record);

    int updateByPrimaryKey(attachmentEntity record);
}