package com.example.foods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.foods.entity.common.*;
import com.example.foods.entity.contact.Order;
import com.example.foods.entity.user.Courier;
import com.example.foods.entity.user.Customer;
import com.example.foods.service.CourierService;
import com.example.foods.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @Autowired
    private OrderService orderService;


    @RequestMapping("/register")
    @ResponseBody
    public ResponseBean register(@RequestBody CourierRegisterRequest registerRequest) {
        Courier one = courierService.getOne(new QueryWrapper<Courier>().eq("id_card", registerRequest.getIdCard()));
        if (one != null) {
            return new ResponseBean().code(CODE.ERROR).message("have registered, please login in directly");
        }
        Courier courier = new Courier();
        BeanUtils.copyProperties(registerRequest, courier);
        boolean save = courierService.save(courier);
        if (!save) {
            return new ResponseBean().code(CODE.ERROR).message("register error");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("register ok");
        }
    }


    @RequestMapping("/login")
    @ResponseBody
    public ResponseBean login(@RequestBody LoginRequest loginRequest) {
        Courier courier = courierService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (courier != null) {
            return new ResponseBean().code(CODE.SUCCESS).message("login success").data(courier);
        } else {
            return new ResponseBean().code(CODE.ERROR).message("login error");
        }
    }

    @RequestMapping("/grabOrder")
    @ResponseBody
    public ResponseBean grabOrder(@RequestParam Integer cid) {
        List<Order> orders = orderService.list(new QueryWrapper<Order>().eq("orders", false));
        int count = orders.size();
        if (count > 0) {
            int rdm = new Random().nextInt(count);  // [0, count-)之间的随机数
            Order order = orders.get(rdm);
            order.setOrders(true);
            order.setCourierId(cid);
            order.setState(OrderState.GRABED);
            boolean save = orderService.saveOrUpdate(order);
            return new ResponseBean().message(save ? "grab success" : "grab error");
        }
        return new ResponseBean().message("no order, wait patient");
    }

    @RequestMapping("/serviced")
    @ResponseBody
    public ResponseBean serviced(@RequestParam Integer oid) {  // 送达
        Order order = orderService.getById(oid);
        order.setDeliveryTime(new Date());
        order.setState(OrderState.RECEIVED);
        boolean update = orderService.updateById(order);
        return new ResponseBean().message(update ? "update success" : "update error");
    }
}
