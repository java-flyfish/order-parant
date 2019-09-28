package com.woollen.order.exception;

import lombok.Data;

/**
 * @Info:
 * @ClassName: OCException
 * @Author: weiyang
 * @Data: 2019/9/28 8:59 AM
 * @Version: V1.0
 **/
@Data
public class OCException extends RuntimeException {
    String msg;

    public OCException(String msg){
        super(msg);
    }
}
