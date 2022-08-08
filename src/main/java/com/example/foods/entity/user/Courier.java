package com.example.foods.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "w_courier")
public class Courier extends User {

    private String name;  // 外卖员要有真实姓名

    private String gender;

    private String orders;

    private Double score;  // 外卖员的评分

    private String idCard;
}
