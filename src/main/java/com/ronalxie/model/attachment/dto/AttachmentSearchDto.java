package com.ronalxie.model.attachment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentSearchDto {

    private String name;

    private String bucket;

    private String type;

    private Date createTime;

}