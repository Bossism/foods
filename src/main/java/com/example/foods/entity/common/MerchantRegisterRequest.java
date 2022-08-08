package com.example.foods.entity.common;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MerchantRegisterRequest {

    private String telephone;

    private String address;

    private String username;

    private String password;

    private String announcement;  //  公告

    private String story;  // 品牌故事

    private String supervisorName;  // 商店管理者

    private String SupervisorTel;

    private String pictureUrl;
}
