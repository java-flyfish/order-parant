package com.woollen.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woollen.order.entry.OrderInfo;
import com.woollen.order.mapper.OrderInfoMapper;
import com.woollen.order.request.OrderForm;
import com.woollen.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Info:
 * @ClassName: OrderInfoServiceImpl
 * @Author: weiyang
 * @Data: 2019/9/27 4:29 PM
 * @Version: V1.0
 **/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public OrderInfo saveOrderInfo(OrderForm form) {
        OrderInfo orderInfo = new OrderInfo();
        int insert = orderInfoMapper.insert(orderInfo);
        return null;
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
}
