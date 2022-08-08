package com.example.foods.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "w_customer")
public class Customer extends User {

    private String gender;

    private Double overage;  // 账户余额？

    private String name;
}
