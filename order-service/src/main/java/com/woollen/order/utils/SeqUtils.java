package com.woollen.order.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Info:
 * @ClassName: SeqUtils
 * @Author: weiyang
 * @Data: 2019/9/28 9:18 AM
 * @Version: V1.0
 **/
public class SeqUtils {

    public static final String PREFIX = "WOO";
    private static long code = 0;
    public static String generatorSeq(){
        code++;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        long m = Long.parseLong((str)) * 10000;
        m += code;
        return PREFIX + m;
    }
}
