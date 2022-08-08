package com.example.foods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.foods.entity.goods.Category;
import com.example.foods.entity.user.Merchant;
import com.example.foods.mapper.MerchantMapper;
import com.example.foods.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Merchant login(String username, String password) {
        return merchantMapper.login(username, password);
    }

    @Override
    public List<Category> getCategory(Integer merchantId) {
        return merchantMapper.getCategory(merchantId);
    }
}
