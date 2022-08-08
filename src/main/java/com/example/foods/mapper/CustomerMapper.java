package com.example.foods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.foods.entity.contact.Order;
import com.example.foods.entity.user.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Order> getOrdersByCusId(Integer cid);

    Customer login(String username, String password);

}
