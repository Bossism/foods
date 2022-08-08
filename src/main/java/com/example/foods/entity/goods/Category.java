package com.example.foods.entity.goods;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "w_category")
public class Category {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer merchantId;
}
