package com.example.foods.entity.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourierRegisterRequest {

    private String telephone;

    private String address;

    private String username;

    private String password;

    private String name;  // 外卖员要有真实姓名

    private String gender;

    private String idCard;
}
