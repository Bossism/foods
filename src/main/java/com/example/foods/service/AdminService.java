package com.example.foods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.foods.entity.user.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService extends IService<Admin> {

    public Admin selectByAdminId(Integer adminId);
}
