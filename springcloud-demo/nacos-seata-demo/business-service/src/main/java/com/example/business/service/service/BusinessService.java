package com.example.business.service.service;


import com.example.business.service.feign.OrderFeignClient;
import com.example.business.service.feign.StorageFeignClient;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: storage-service
 * @description: BusinessService
 * @author: loulvlin
 * @create: 2020-05-06 14:51
 **/
@Service
public class BusinessService {

    private static final Logger logger = LoggerFactory.getLogger(BusinessService.class);
    @Resource
    private StorageFeignClient storageFeignClient;
    @Resource
    private OrderFeignClient orderFeignClient;

    /**
     * 减库存，下订单
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @GlobalTransactional(timeoutMills = 300000)
    public void purchase(String userId, String commodityCode, int orderCount) {
        logger.info("开始全局事务，XID = " + RootContext.getXID());
        storageFeignClient.deduct(commodityCode, orderCount);

        orderFeignClient.create(userId, commodityCode, orderCount);
    }
}
