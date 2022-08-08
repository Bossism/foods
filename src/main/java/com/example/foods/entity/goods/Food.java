package com.example.foods.entity.goods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@TableName(value = "w_food")
public class Food implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String foodName;

    private String description;

    private Double price;

    private Integer categoryId; //所属类别

    private Integer sales;  // 销量

    private Double appraisal;  // 评价 好评率

    private Integer merchantId;  // 商家id

    private String pictureUrl;
}
