package com.woollen.order.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Info:
 * @ClassName: PayOrderForm
 * @Author: weiyang
 * @Data: 2019/9/28 11:11 AM
 * @Version: V1.0
 **/
@ApiModel("订单支付from")
@Data
public class PayOrderForm {
    @ApiModelProperty(value = "订单号",required = true)
    @NotBlank(message = "订单号不能为空！")
    private String seq;
}
