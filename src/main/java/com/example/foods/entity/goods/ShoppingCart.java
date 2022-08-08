package com.example.foods.entity.goods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@TableName(value = "w_shopping_cart")
public class ShoppingCart implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer merchantId;

    private String foodIds;

    private Integer customerId;

    private Double totalPrice;
}
