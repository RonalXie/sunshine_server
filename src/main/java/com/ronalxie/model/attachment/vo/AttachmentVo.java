package com.ronalxie.model.attachment.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentVo {
    private Long id;

    private String name;

    private String bucket;

    private Long size;

    private String url;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


}