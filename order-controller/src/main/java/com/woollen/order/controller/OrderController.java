package com.woollen.order.controller;

import com.github.doublebin.springfox.bridge.core.builder.annotations.BridgeGroup;
import com.woollen.order.base.BaseController;
import com.woollen.order.entry.OrderInfo;
import com.woollen.order.exception.OCException;
import com.woollen.order.request.CreateOrderForm;
import com.woollen.order.request.PayOrderForm;
import com.woollen.order.response.Result;
import com.woollen.order.service.OrderInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
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
@ApiModel(reference = "order")
@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value = "创建订单", notes = "创建订单", response = OrderInfo.class, position = -1)
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

    @ApiOperation(value = "订单支付", notes = "订单支付传入订单号", response = Map.class, position = -1)
    @PostMapping("payOrder")
    public Result payOrder( @Valid PayOrderForm form, BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                throw new OCException(error.getDefaultMessage());
            }
        }
        Map<String,String> resultMap = orderInfoService.payOrder(form.getSeq());
        return success(resultMap);
    }

    @ApiOperation(value = "获取短信验证码", notes = "获取短信验证码传入订手机号", response = Boolean.class, position = -1)
    @GetMapping("smsCode")
    public Result smsCode(String phone){
        orderInfoService.sendSmsCode(phone);
        return success(true);
    }
}
