package com.ronalxie.mapper;

import com.ronalxie.model.attachment.AttachmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AttachmentEntity record);

    int insertSelective(AttachmentEntity record);

    AttachmentEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AttachmentEntity record);

    int updateByPrimaryKey(AttachmentEntity record);

    List<AttachmentEntity> selectAllList(AttachmentEntity attachment);
}
