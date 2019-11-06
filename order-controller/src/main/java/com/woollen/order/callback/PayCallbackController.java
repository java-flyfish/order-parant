package com.woollen.order.callback;

import com.woollen.order.base.BaseController;
import com.woollen.order.entry.OrderInfo;
import com.woollen.order.service.OrderInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Info:
 * @ClassName: PayCallbackController
 * @Author: weiyang
 * @Data: 2019/9/28 11:19 AM
 * @Version: V1.0
 **/
@ApiModel(reference = "payCallback")
@RestController
@RequestMapping("payCallback")
public class PayCallbackController extends BaseController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value = "支付回调", notes = "支付回调", response = String.class, position = -1)
    @GetMapping("weixin")
    public String weixinCallback(String orderNum,String outSeq){

        Boolean b = orderInfoService.payCallback(orderNum, outSeq);
        return "true";

    }
}
