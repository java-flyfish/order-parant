package com.woollen.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woollen.order.entry.OrderInfo;
import com.woollen.order.enums.EnumOrderStatusType;
import com.woollen.order.exception.OCException;
import com.woollen.order.mapper.OrderInfoMapper;
import com.woollen.order.service.OrderInfoService;
import com.woollen.order.utils.RedisUtils;
import com.woollen.order.utils.SeqUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Info:
 * @ClassName: OrderInfoServiceImpl
 * @Author: weiyang
 * @Data: 2019/9/27 4:29 PM
 * @Version: V1.0
 **/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public OrderInfo createOrderInfo(OrderInfo form,String smsCode) {

        checkCode(form.getPhone(),smsCode);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setName(form.getName());
        orderInfo.setPhone(form.getPhone());
        orderInfo.setAdtSource(form.getAdtSource());
        orderInfo.setStatus(EnumOrderStatusType.PAY_UN.getValue());
        orderInfo.setCreated(System.currentTimeMillis());
        orderInfo.setUpdated(System.currentTimeMillis());
        String seq = SeqUtils.generatorSeq();
        orderInfo.setSeq(seq);
        int insert = orderInfoMapper.insert(orderInfo);
        if (insert < 1){
            throw new OCException("创建订单失败！");
        }
        return orderInfo;
    }

    @Override
    public PageInfo selectOrderInfo(OrderInfo orderInfo) {

        QueryWrapper<OrderInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("name","aaa");
        PageHelper.startPage(1,2);
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(wrapper);
        PageInfo pageInfo = new PageInfo(orderInfos);
        return pageInfo;
    }

    @Override
    public Map<String, String> payOrder(String seq) {
        //todo 对接微信支付，生成支付信息

        return null;
    }

    @Override
    public void sendSmsCode(String phone) {
        Long expire = redisTemplate.getExpire(RedisUtils.ORDER_SMS_CODE_PREFIX + phone, TimeUnit.MINUTES);
        if (expire > 9){
            throw new OCException("请勿频繁发送验证码！");
        }

        int smsCode = (int) Math.ceil(Math.random() * 9000 + 1000);
        logger.info("购买会员短信验证码：{}",smsCode);
        //todo 发送验证码
        redisTemplate.opsForValue().set(RedisUtils.ORDER_SMS_CODE_PREFIX + phone,smsCode+"",10,TimeUnit.MINUTES);
    }

    Boolean checkCode(String phone,String smsCode){
        String code = redisTemplate.opsForValue().get(RedisUtils.ORDER_SMS_CODE_PREFIX + phone);
        if (StringUtils.isBlank(smsCode)){
            throw new OCException("请输入验证码！");
        }

        if (!smsCode.equals(code)){
            throw new OCException("验证码不正确！");
        }
        return true;
    }
}