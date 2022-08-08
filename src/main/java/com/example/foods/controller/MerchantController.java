package com.example.foods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.foods.entity.common.*;
import com.example.foods.entity.goods.Category;
import com.example.foods.entity.goods.Food;
import com.example.foods.entity.user.Merchant;
import com.example.foods.service.CategoryService;
import com.example.foods.service.FoodService;
import com.example.foods.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoodService foodService;


    @RequestMapping("/register")
    @ResponseBody
    public ResponseBean register(@RequestBody MerchantRegisterRequest registerRequest) {
        Merchant merchant = new Merchant();
        merchant.setTelephone(registerRequest.getTelephone());
        merchant.setAddress(registerRequest.getAddress());
        merchant.setPassword(registerRequest.getPassword());
        merchant.setUsername(registerRequest.getUsername());
        merchant.setAnnouncement(registerRequest.getAnnouncement());
        merchant.setStory(registerRequest.getStory());
        merchant.setSupervisorName(registerRequest.getSupervisorName());
        merchant.setSupervisorTel(registerRequest.getSupervisorTel());
        merchant.setPictureUrl(registerRequest.getPictureUrl());
        boolean save = merchantService.save(merchant);
        return new ResponseBean().message(save ? "register success" : "register error");
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResponseBean login(@RequestBody LoginRequest loginRequest) {
        Merchant merchant = merchantService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (merchant == null) {
            return new ResponseBean().message("please register").code(CODE.ERROR);
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("login success").data(merchant);
        }
    }

    @RequestMapping("/addCategory")
    @ResponseBody
    public ResponseBean addCategory(@RequestParam String name, @RequestParam Integer merchantId) {
        Category category = new Category();
        category.setName(name);
        category.setMerchantId(merchantId);
        boolean save = categoryService.save(category);
        return new ResponseBean().message(save ? "add success" : "add error");
    }

    @RequestMapping("/getAllCategory")
    @ResponseBody
    public ResponseBean getAllCategory(@RequestParam Integer id) {

        List<Category> category = merchantService.getCategory(id);
        if (category.size() != 0) {
            return new ResponseBean().code(CODE.SUCCESS).message("categories").data(category);
        } else {
            return new ResponseBean().code(CODE.ERROR).message("no categories");
        }
    }

    @RequestMapping("/getAllFoods")
    @ResponseBody
    public ResponseBean getAllFoods(@RequestParam Integer merchantId) {
        List<Food> foods = foodService.list(new QueryWrapper<Food>().ge("merchant_id", merchantId));
        if (foods.size() == 0) {
            return new ResponseBean().code(CODE.ERROR).message("no food");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("all foods").data(foods);
        }
    }

    @RequestMapping("/addFood")
    @ResponseBody
    public ResponseBean addFood(@RequestBody CreateFoodRequest foodRequest, HttpServletResponse response) {
        Food food = new Food();
        food.setFoodName(foodRequest.getFoodName());
        food.setDescription(foodRequest.getDescription());
        food.setPrice(foodRequest.getPrice());
        food.setCategoryId(foodRequest.getCategoryId());
        food.setMerchantId(foodRequest.getMerchantId());
        food.setPictureUrl(foodRequest.getPictureUrl());
        boolean save = foodService.save(food);
        response.setHeader("s", "efdsdfs");
        return new ResponseBean().message(save ? "add success" : "add error");
    }
}
