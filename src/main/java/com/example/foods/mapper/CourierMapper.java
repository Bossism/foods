package com.example.foods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.foods.entity.user.Courier;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourierMapper extends BaseMapper<Courier> {

    Courier login(String username, String password);
}
