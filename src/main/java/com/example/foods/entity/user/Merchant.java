package com.example.foods.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import javax.print.DocFlavor;

@Data
@ToString
@TableName(value = "w_merchant")
public class Merchant extends User{

    private String announcement;  //  公告

    private String story;  // 品牌故事

    private String supervisorName;  // 商店管理者

    private String SupervisorTel;

    private String pictureUrl;

    private Double score;
}
