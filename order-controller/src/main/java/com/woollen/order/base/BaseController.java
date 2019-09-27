package com.woollen.order.base;

import com.woollen.order.response.Result;

/**
 * @Info:
 * @ClassName: BaseController
 * @Author: weiyang
 * @Data: 2019/9/27 3:58 PM
 * @Version: V1.0
 **/
public class BaseController {
    public Result success(Object data){
        return new Result(data,true,"处理成功");
    }

    public Result error(String msg){
        return new Result(null,false,msg);
    }
}
