package com.example.foods.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class CreateReplyRequest {

    private Integer orderId;

    private Integer star;

    private String content;

//    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss" )
//    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
private Date time;

}
