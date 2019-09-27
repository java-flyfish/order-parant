package com.woollen.order.service;

import com.github.pagehelper.PageInfo;
import com.woollen.order.entry.OrderInfo;
import com.woollen.order.request.OrderForm;

/**
 * @Info:
 * @ClassName: OrderInfoService
 * @Author: weiyang
 * @Data: 2019/9/27 4:28 PM
 * @Version: V1.0
 **/
public interface OrderInfoService {
    OrderInfo saveOrderInfo(OrderForm form);
    PageInfo selectOrderInfo(OrderInfo orderInfo);
}
