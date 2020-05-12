package com.example.order.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.order.service.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: storage-service
 * @description: OrderDAO
 * @author: loulvlin
 * @create: 2020-05-06 14:24
 **/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
