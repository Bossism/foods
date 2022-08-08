package com.example.foods.entity.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddFoodToShopCartRequest {

    private Integer foodId;

    private Integer merchantId;

    private Integer customerId;
}
