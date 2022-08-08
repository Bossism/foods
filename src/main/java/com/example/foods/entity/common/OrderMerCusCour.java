package com.example.foods.entity.common;

import com.example.foods.entity.contact.Reply;
import com.example.foods.entity.user.Courier;
import com.example.foods.entity.user.Customer;
import com.example.foods.entity.user.Merchant;
import lombok.Data;

import java.util.Date;

@Data
public class OrderMerCusCour {

    private Customer customer;

    private Merchant merchant;

    private String foods;

    private Double deliveryFee;  // 配送费

    private String remark;  // 备注

    private Integer tableware;  // 餐具

    private boolean invoice;  // 是否需要发票

    private boolean orders;  // 是否被接单

    private Courier courier;  // 骑手id

    private Date deliveryTime;  // 送达时间

    private Reply reply;  // 评价

    private String state;  // 订单状态 -1取消订单退款 0完成  1处理中

}
