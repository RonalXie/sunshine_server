package com.ronalxie.model.attachment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentEntity {
    private Long id;

    private String name;

    private String bucket;

    private String type;

    private Long size;

    private String url;

    private Long userId;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}