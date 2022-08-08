package com.example.foods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.foods.entity.contact.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService extends IService<Order> {

    List<Order> orderList(Integer cid);

}
