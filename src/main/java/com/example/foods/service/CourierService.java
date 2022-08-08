package com.example.foods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.foods.entity.user.Courier;
import org.springframework.stereotype.Service;

@Service
public interface CourierService extends IService<Courier> {

    Courier login(String username, String password);
}
