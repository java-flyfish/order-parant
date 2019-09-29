package com.woollen.order.callback;

import com.woollen.order.base.BaseController;
import com.woollen.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Info:
 * @ClassName: PayCallbackController
 * @Author: weiyang
 * @Data: 2019/9/28 11:19 AM
 * @Version: V1.0
 **/
@RestController
@RequestMapping("payCallback")
public class PayCallbackController extends BaseController {

    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping("weixin")
    public String weixinCallback(){

        Boolean b = orderInfoService.payCallback("WOO201909281014220001", "213445674343457654");
        return "true";

    }
}
