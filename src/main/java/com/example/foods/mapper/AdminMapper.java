package com.example.foods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.foods.entity.user.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    Admin selectByAdminId(@Param("adminId") Integer adminId);
}
