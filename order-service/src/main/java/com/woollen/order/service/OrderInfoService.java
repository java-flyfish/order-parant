package com.woollen.order.service;

import com.github.pagehelper.PageInfo;
import com.woollen.order.entry.OrderInfo;

import java.util.Map;

/**
 * @Info:
 * @ClassName: OrderInfoService
 * @Author: weiyang
 * @Data: 2019/9/27 4:28 PM
 * @Version: V1.0
 **/
public interface OrderInfoService {
    OrderInfo createOrderInfo(OrderInfo form,String smsCode);
    PageInfo selectOrderInfo(OrderInfo orderInfo);

    Map<String,String> payOrder(String seq);

    void sendSmsCode(String phone);
}
