package com.example.foods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.foods.entity.user.Admin;
import com.example.foods.mapper.AdminMapper;
import com.example.foods.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired  // @Resource?
    private AdminMapper adminMapper;

    @Override
    public Admin selectByAdminId(Integer adminId) {
        return adminMapper.selectByAdminId(adminId);
    }

}
