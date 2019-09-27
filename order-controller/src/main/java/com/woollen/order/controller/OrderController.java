package com.woollen.order.controller;

import com.github.pagehelper.PageInfo;
import com.woollen.order.base.BaseController;
import com.woollen.order.entry.OrderInfo;
import com.woollen.order.request.OrderForm;
import com.woollen.order.response.Result;
import com.woollen.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Info:
 * @ClassName: OrderController
 * @Author: weiyang
 * @Data: 2019/9/27 2:39 PM
 * @Version: V1.0
 **/
@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

    @Autowired
    private OrderInfoService orderInfoService;

    @PostMapping("createdOrder")
    public Result createOrder(OrderForm form){
        OrderInfo integer = orderInfoService.saveOrderInfo(form);
        return success(integer);
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
