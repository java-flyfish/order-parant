package com.woollen.order.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Info:
 * @ClassName: request
 * @Author: weiyang
 * @Data: 2019/9/27 5:05 PM
 * @Version: V1.0
 **/
@Data
@ApiModel("创建订单from")
public class CreateOrderForm {

    @ApiModelProperty(value = "手机号",required = true)
    @NotBlank(message = "请输入手机号！")
    @Pattern(regexp="^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$",message="手机号格式不正确！")
    private String phone;

    @ApiModelProperty(value = "用户姓名",required = true)
    @NotBlank(message = "请输入姓名！")
    private String name;

    @ApiModelProperty(value = "短信验证码",required = true)
    @NotBlank(message = "请输入短信验证码！")
    private String smsCode;

    @ApiModelProperty(value = "订单来源",required = true)
    @NotBlank(message = "填写订单来源！")
    private String adtSource;
}
