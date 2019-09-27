package com.woollen.order.request;

import lombok.Data;

/**
 * @Info:
 * @ClassName: OrderForm
 * @Author: weiyang
 * @Data: 2019/9/27 4:01 PM
 * @Version: V1.0
 **/
@Data
public class OrderForm {
    String phone;
    String name;
    String smsCode;
}
