package com.example.foods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.foods.entity.contact.Order;
import com.example.foods.entity.user.Customer;
import com.example.foods.mapper.CustomerMapper;
import com.example.foods.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Order> getOrdersByCusId(Integer cid) {
        return customerMapper.getOrdersByCusId(cid);
    }

    @Override
    public Customer login(String username, String password) {
        return customerMapper.login(username, password);
    }

}
