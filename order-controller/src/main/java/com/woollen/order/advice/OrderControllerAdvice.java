package com.woollen.order.advice;

import com.woollen.order.base.BaseController;
import com.woollen.order.exception.OCException;
import com.woollen.order.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Info:
 * @ClassName: OrderControllerAdvice
 * @Author: weiyang
 * @Data: 2019/9/28 10:23 AM
 * @Version: V1.0
 **/
@ControllerAdvice
public class OrderControllerAdvice extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {
        logger.error("统一异常处理，Exception：{}",ex);
        return error(ex.getMessage());
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = OCException.class)
    public Result myErrorHandler(OCException ex) {
        logger.error("统一异常处理，OCException：{}",ex);
        return error(ex.getMessage());
    }
}
