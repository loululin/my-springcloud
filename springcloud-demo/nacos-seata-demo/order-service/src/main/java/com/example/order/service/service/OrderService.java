package com.example.order.service.service;


import com.example.order.service.dao.OrderMapper;
import com.example.order.service.entity.Order;
import com.example.order.service.feign.AccountFeignClient;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: storage-service
 * @description: OrderService
 * @author: loulvlin
 * @create: 2020-05-06 14:23
 **/
@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Resource
    private AccountFeignClient accountFeignClient;

    @Resource
    private OrderMapper orderMapper;

    @Transactional
    public void create(String userId, String commodityCode, Integer count) {
        logger.info("开始全局事务，XID = " + RootContext.getXID());
        int orderMoney = count * 5;
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        //创建订单
        orderMapper.insert(order);
        //账户扣款
        accountFeignClient.debit(userId, orderMoney);
    }


}
