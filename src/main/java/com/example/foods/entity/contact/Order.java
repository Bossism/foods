package com.example.foods.entity.contact;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.foods.entity.goods.Food;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@TableName(value = "w_order")
public class Order implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer customerId;

    private Integer merchantId;

    private String foodIds;

    private Double totalPrice;

    private Double deliveryFee;  // 配送费

    private String remark;  // 备注

    private Integer tableware;  // 餐具

    private boolean invoice;  // 是否需要发票

    private boolean orders;  // 是否被接单

    private Integer courierId;  // 骑手id

    private Date deliveryTime;  // 送达时间

    private Integer replyId;  // 评价

    private String state;  // 订单状态 -1取消订单退款 0完成  1已经下单未接单 2接单配送中

}
