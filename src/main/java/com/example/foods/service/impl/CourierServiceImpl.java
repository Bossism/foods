package com.example.foods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.foods.entity.common.CourierRegisterRequest;
import com.example.foods.entity.user.Courier;
import com.example.foods.mapper.CourierMapper;
import com.example.foods.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceImpl extends ServiceImpl<CourierMapper, Courier> implements CourierService {

    @Autowired
    private CourierMapper courierMapper;

    public Courier login(String username, String password) {
        return courierMapper.login(username, password);
    }
}
