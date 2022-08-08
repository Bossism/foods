package com.example.foods.entity.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateFoodRequest {

    private String foodName;

    private String description;

    private Double price;

    private Integer categoryId; //所属类别

    private Integer merchantId;  // 商家id

    private String pictureUrl;
}
