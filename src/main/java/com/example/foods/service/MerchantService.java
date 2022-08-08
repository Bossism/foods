package com.example.foods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.foods.entity.goods.Category;
import com.example.foods.entity.user.Merchant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MerchantService extends IService<Merchant> {

    Merchant login(String username, String password);

    List<Category> getCategory(Integer merchantId);
}
