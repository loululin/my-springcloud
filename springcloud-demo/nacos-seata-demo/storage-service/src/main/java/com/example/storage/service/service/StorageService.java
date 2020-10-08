package com.example.storage.service.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.storage.service.dao.StorageMapper;
import com.example.storage.service.entity.Order;
import com.example.storage.service.entity.Storage;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: aos-project
 * @description: StorageService
 * @author: loulvlin
 * @create: 2020-05-06 09:33
 **/
@Service
public class StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageService.class);
    @Resource
    private StorageMapper storageMapper;

    @Resource
    private StorageService self;

    @Resource
    private com.example.storage.service.dao.OrderMapper orderMapper;

    @Transactional
    public void deduct(String commodityCode, int count) {
        logger.info("开始全局事务，XID = " + RootContext.getXID());
        QueryWrapper<Storage> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new Storage().setCommodityCode(commodityCode));


        Storage storage = storageMapper.selectOne(wrapper);
        storage.setCount(storage.getCount() - count);

        storageMapper.updateById(storage);

//        self.create("1002","2001",4);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DS("order")
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
        int aa = 10 / 0;
    }





}
