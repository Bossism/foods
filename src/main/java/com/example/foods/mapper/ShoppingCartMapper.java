package com.example.foods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.foods.entity.goods.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
