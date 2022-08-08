package com.example.foods.entity.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateOrderRequest {

    private Integer shopCartId;

    private String remark;  // 备注

    private Integer tableware;  // 餐具

    private boolean invoice;  // 是否需要发票

    private boolean orders;  // 是否被接单
}
