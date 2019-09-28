package com.woollen.order.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Info:
 * @ClassName: PayOrderForm
 * @Author: weiyang
 * @Data: 2019/9/28 11:11 AM
 * @Version: V1.0
 **/
@Data
public class PayOrderForm {
    @NotBlank(message = "订单号不能为空！")
    private String seq;
}
