package com.example.foods.controller;

import com.example.foods.entity.common.CODE;
import com.example.foods.entity.common.ResponseBean;
import com.example.foods.entity.user.Admin;
import com.example.foods.entity.user.Courier;
import com.example.foods.entity.user.Customer;
import com.example.foods.entity.user.Merchant;
import com.example.foods.service.AdminService;
import com.example.foods.service.CourierService;
import com.example.foods.service.CustomerService;
import com.example.foods.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private CourierService courierService;
    // 分页查询

    @RequestMapping("/queryAdminById")
    @ResponseBody
    public ResponseBean queryAdminById(@RequestParam Integer id) {
        Admin admin = adminService.selectByAdminId(id);
        if (admin == null) {
            return new ResponseBean().code(CODE.ERROR).message("cant find admin byId").data("");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("adminById").data(admin);
        }
    }

    @RequestMapping("/queryAllCustomers")
    @ResponseBody  // 返回json格式的数据
    public ResponseBean queryAllCustomers() {
        List<Customer> customers = customerService.list();
        if (customers == null) {
            return new ResponseBean().code(CODE.ERROR).message("no customer").data("");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("allCustomer").data(customers);
        }
    }

    @RequestMapping("/queryAllMerchants")
    @ResponseBody
    public ResponseBean queryAllMerchants() {
        List<Merchant> merchants = merchantService.list();
        if (merchants == null) {
            return new ResponseBean().code(CODE.ERROR).message("no merchants").data("");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("allMerchants").data(merchants);
        }
    }

    @RequestMapping("/queryAllCourier")
    @ResponseBody  // 返回json格式的数据
    public ResponseBean queryAllCourier() {
        List<Courier> couriers = courierService.list();
        if (couriers == null) {
            return new ResponseBean().code(CODE.ERROR).message("no couriers").data("");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("allCouriers").data(couriers);
        }
    }

    @RequestMapping("/queryCustomerById")
    @ResponseBody
    public ResponseBean queryCustomerById(@RequestParam Integer id) {
        Customer customer = customerService.getById(id);
        if (customer == null) {
            return new ResponseBean().code(CODE.ERROR).message("cant find customer").data("");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("customerById").data(customer);
        }
    }

    @RequestMapping("/queryMerchantById")
    @ResponseBody
    public ResponseBean queryMerchantById(@RequestParam Integer id) {
        Merchant merchant = merchantService.getById(id);
        if (merchant != null) {
            return new ResponseBean().code(CODE.SUCCESS).message("merchantById").data(merchant);
        } else {
            return new ResponseBean().code(CODE.ERROR).message("cant find").data("");
        }

    }

    @RequestMapping("/queryCourierById")
    @ResponseBody
    public ResponseBean queryCourierById(@RequestParam Integer id) {
        Courier courier = courierService.getById(id);
        if (courier == null) {
            return new ResponseBean().code(CODE.ERROR).message("no courier").data("");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("allCourier").data(courier);
        }
    }

    @RequestMapping("/addMerchant")
    @ResponseBody
    public ResponseBean addMerchant(@RequestParam Merchant merchant) {
        boolean save = merchantService.save(merchant);
        return new ResponseBean().code(save ? CODE.SUCCESS : CODE.ERROR);
    }

    @RequestMapping("/addCustomer")
    @ResponseBody
    public ResponseBean addCustomer(@RequestParam Customer customer) {
        boolean save = customerService.save(customer);
        return new ResponseBean().code(save ? CODE.SUCCESS : CODE.ERROR);
    }

    @RequestMapping("/addCourier")
    @ResponseBody
    public ResponseBean addCourier(@RequestParam Courier courier) {
        boolean save = courierService.save(courier);
        return new ResponseBean().code(save ? CODE.SUCCESS : CODE.ERROR);
    }

    @RequestMapping("/deleteMerchantById")
    @ResponseBody
    public ResponseBean deleteMerchantById(@RequestParam Integer id) {
        boolean remove = merchantService.removeById(id);
        return new ResponseBean().code(remove ? CODE.SUCCESS : CODE.ERROR);
    }

    @RequestMapping("/deleteCustomerById")
    @ResponseBody
    public ResponseBean deleteCustomerById(@RequestParam Integer id) {
        boolean remove = customerService.removeById(id);
        return new ResponseBean().code(remove ? CODE.SUCCESS : CODE.ERROR);
    }

    @RequestMapping("/deleteCourierById")
    @ResponseBody
    public ResponseBean deleteCourierById(@RequestParam Integer id) {
        boolean remove = courierService.removeById(id);
        return new ResponseBean().code(remove ? CODE.SUCCESS : CODE.ERROR);
    }

    @RequestMapping("/updateCustomer")
    @ResponseBody
    public ResponseBean updateCustomer(@RequestParam Customer customer) {
        boolean update = customerService.updateById(customer);
        return new ResponseBean().code(update ? CODE.SUCCESS : CODE.ERROR);
    }

    @RequestMapping("/updateMerchant")
    @ResponseBody
    public ResponseBean updateMerchant(@RequestParam Merchant merchant) {
        boolean update = merchantService.updateById(merchant);
        return new ResponseBean().code(update ? CODE.SUCCESS : CODE.ERROR);
    }

    @RequestMapping("/updateCourier")
    @ResponseBody
    public ResponseBean updateCourier(@RequestParam Courier courier) {
        boolean update = courierService.updateById(courier);
        return new ResponseBean().code(update ? CODE.SUCCESS : CODE.ERROR);
    }


}
