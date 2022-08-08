package com.example.foods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.foods.entity.goods.Food;
import org.springframework.stereotype.Service;

@Service
public interface FoodService extends IService<Food> {

}
