package com.woollen.order.request;

import lombok.Data;

/**
 * @Info:
 * @ClassName: request
 * @Author: weiyang
 * @Data: 2019/9/27 5:05 PM
 * @Version: V1.0
 **/
@Data
public class OrderForm {
    private String phone;
    private String name;
    private String smsCode;
    private String adtSource;
}
