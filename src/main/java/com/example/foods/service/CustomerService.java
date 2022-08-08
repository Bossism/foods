package com.example.foods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.foods.entity.contact.Order;
import com.example.foods.entity.user.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService extends IService<Customer> {

    List<Order> getOrdersByCusId(Integer cid);

    Customer login(String username, String password);
}
