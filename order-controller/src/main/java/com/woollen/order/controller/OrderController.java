package com.woollen.order.controller;

import com.woollen.order.base.BaseController;
import com.woollen.order.entry.OrderInfo;
import com.woollen.order.exception.OCException;
import com.woollen.order.request.CreateOrderForm;
import com.woollen.order.request.PayOrderForm;
import com.woollen.order.response.Result;
import com.woollen.order.service.OrderInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

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
    public Result createOrder(@Valid CreateOrderForm form,BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                throw new OCException(error.getDefaultMessage());
            }
        }
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(form,orderInfo);
        OrderInfo integer = orderInfoService.createOrderInfo(orderInfo,form.getSmsCode());
        return success(integer);
    }

    @PostMapping("payOrder")
    public Result payOrder(@Valid PayOrderForm form, BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                throw new OCException(error.getDefaultMessage());
            }
        }
        Map<String,String> resultMap = orderInfoService.payOrder(form.getSeq());
        return success(resultMap);
    }


    @GetMapping("smsCode")
    public Result smsCode(String phone){
        orderInfoService.sendSmsCode(phone);
        return success(true);
    }
}
