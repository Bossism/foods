package com.example.foods.entity.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerRegisterRequest {

    private String telephone;

    private String address;

    private String username;

    private String password;

    private String gender;

    private String name;
}
