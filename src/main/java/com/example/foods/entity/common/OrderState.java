package com.example.foods.entity.common;

public class OrderState {

    public static final String UNPAID = "UNPAID";                // 未付款
    public static final String ORDEREDUNGRAB = "ORDEREDUNGRAB";  // 下单但未接单
    public static final String GRABED = "GRABED";                //  下单且接单
    public static final String RECEIVED = "RECEIVED";            //  送达
    public static final String RETURNED = "RETURNED";            //  退货

}
