package com.example.foods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.foods.entity.goods.Category;
import com.example.foods.entity.user.Merchant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MerchantMapper extends BaseMapper<Merchant> {

    Merchant login(String username, String password);

    List<Category> getCategory(Integer merchantId);

}
