package com.woollen.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Info:
 * @ClassName: OrderController
 * @Author: weiyang
 * @Data: 2019/9/27 2:39 PM
 * @Version: V1.0
 **/
@RestController
public class OrderController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
