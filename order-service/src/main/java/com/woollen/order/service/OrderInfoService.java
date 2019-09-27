package com.woollen.order.service;

import com.github.pagehelper.PageInfo;
import com.woollen.order.entry.OrderInfo;

/**
 * @Info:
 * @ClassName: OrderInfoService
 * @Author: weiyang
 * @Data: 2019/9/27 4:28 PM
 * @Version: V1.0
 **/
public interface OrderInfoService {
    Integer saveOrderInfo(OrderInfo orderInfo);
    PageInfo selectOrderInfo(OrderInfo orderInfo);
}
