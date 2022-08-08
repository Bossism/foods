package com.example.foods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.foods.entity.common.*;
import com.example.foods.entity.contact.Order;
import com.example.foods.entity.contact.Reply;
import com.example.foods.entity.goods.ShoppingCart;
import com.example.foods.entity.user.Customer;
import com.example.foods.entity.user.Merchant;
import com.example.foods.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private CourierService courierService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private FoodService foodService;


    @RequestMapping("/register")
    @ResponseBody
    public ResponseBean register(@RequestBody CustomerRegisterRequest registerRequest) {
        Customer customer = new Customer();
        customer.setGender(registerRequest.getGender());
        customer.setTelephone(registerRequest.getTelephone());
        customer.setAddress(registerRequest.getAddress());
        customer.setUsername(registerRequest.getUsername());
        customer.setPassword(registerRequest.getPassword());
        customer.setOverage(0.);
        customer.setName(registerRequest.getName());
        boolean save = customerService.save(customer);
        if (!save) {
            return new ResponseBean().code(CODE.ERROR).message("register error");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("register ok");
        }
    }

    /**
     * 返回的是ture还是用户信息比较好
     *
     * @param loginRequest
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResponseBean login(@RequestBody LoginRequest loginRequest) {
        Customer customer = customerService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (customer != null) {
            return new ResponseBean().code(CODE.SUCCESS).message("login sucess").data(customer);
        } else {
            return new ResponseBean().code(CODE.ERROR).message("login error");
        }
    }

    @RequestMapping("/getInfoById")
    @ResponseBody
    public ResponseBean getCustomerInfoById(@RequestParam Integer cid) {
        Customer customer = customerService.getById(cid);
        if (customer != null) {
            return new ResponseBean().code(CODE.SUCCESS).message("customerById").data(customer);
        } else {
            return new ResponseBean().code(CODE.ERROR);
        }
    }

    @RequestMapping("/getOrdersByCusId")
    @ResponseBody
    public ResponseBean getOrdersByCusId(@RequestParam Integer cid) {
        List<Order> orders = orderService.orderList(cid);
        List<OrderMerCusCour> orderMerCusCours = new LinkedList<>();
        if (orders.size() > 0) {
            for (Order order : orders) {
                OrderMerCusCour orderMerCusCour = new OrderMerCusCour();
                BeanUtils.copyProperties(order, orderMerCusCour);
                orderMerCusCour.setCustomer(customerService.getById(cid));
                orderMerCusCour.setCourier(courierService.getById(order.getCourierId()));
                orderMerCusCour.setMerchant(merchantService.getById(order.getMerchantId()));
                orderMerCusCour.setReply(replyService.getById(order.getReplyId()));
                orderMerCusCours.add(orderMerCusCour);
            }
            return new ResponseBean().code(CODE.SUCCESS).data(orderMerCusCours).message("ordersByCustomerId");
        }
        return new ResponseBean().code(CODE.SUCCESS).message("no orders");
    }

    @RequestMapping("/getAllMerchant")
    @ResponseBody
    public ResponseBean getAllMerchant() {
        List<Merchant> merchants = merchantService.list();
        if (merchants.size() == 0) {
            return new ResponseBean().code(CODE.ERROR).message("no merchants");
        } else {
            return new ResponseBean().code(CODE.SUCCESS).message("all merchants").data(merchants);
        }
    }

    @RequestMapping("/addFoodToShopCart")
    @ResponseBody
    public ResponseBean addFoodToShopCart(@RequestBody AddFoodToShopCartRequest foodRequest) {
        QueryWrapper<ShoppingCart> wrapper = new QueryWrapper<>();
        wrapper.eq("merchant_id", foodRequest.getMerchantId());
        ShoppingCart shoppingCart = shoppingCartService.getOne(wrapper);
        if (shoppingCart != null) {
            String foodIds = shoppingCart.getFoodIds();
            shoppingCart.setFoodIds(foodIds + "," + foodRequest.getFoodId());
            Double totalPrices = shoppingCart.getTotalPrice();
            shoppingCart.setTotalPrice(totalPrices + foodService.getById(foodRequest.getFoodId()).getPrice());
            shoppingCartService.updateById(shoppingCart);
        } else {
            ShoppingCart newShopCart = new ShoppingCart();
            BeanUtils.copyProperties(foodRequest, newShopCart);
            newShopCart.setTotalPrice(foodService.getById(foodRequest.getFoodId()).getPrice());
            newShopCart.setFoodIds(Integer.toString(foodRequest.getFoodId()));
            shoppingCartService.save(newShopCart);
        }
        return new ResponseBean().code(CODE.SUCCESS).message("add food success");
    }


    @RequestMapping("/order")
    @ResponseBody
    public ResponseBean order(@RequestBody CreateOrderRequest createOrderRequest) {
        ShoppingCart cart = shoppingCartService.getById(createOrderRequest.getShopCartId());
        Order order = new Order();
        BeanUtils.copyProperties(cart, order);
        BeanUtils.copyProperties(createOrderRequest, order);
        order.setDeliveryFee(new Random().nextDouble() * 15);
        order.setState(OrderState.ORDEREDUNGRAB); //
        boolean save = orderService.save(order);
        return new ResponseBean().code(CODE.SUCCESS).message(save ? "order success" : "order error").data(order);
    }

    @RequestMapping("/addReply")
    @ResponseBody
    public ResponseBean addReply(@RequestBody CreateReplyRequest replyRequest) {
        Reply reply = new Reply();
        BeanUtils.copyProperties(replyRequest, reply);
        Order order = orderService.getById(replyRequest.getOrderId());
        reply.setCustomerId(order.getCustomerId());
        reply.setMerchantId(order.getMerchantId());
        boolean saveOrUpdate = replyService.saveOrUpdate(reply);
        int replyId = replyService.getOne(new QueryWrapper<Reply>().eq("order_id", order.getId())).getId();
        order.setReplyId(replyId);
        orderService.saveOrUpdate(order);
        return new ResponseBean().message(saveOrUpdate ? "add reply success" : "add reply error");
    }
}
