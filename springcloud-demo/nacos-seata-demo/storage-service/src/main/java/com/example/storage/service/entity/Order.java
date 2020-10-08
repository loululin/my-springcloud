package com.example.storage.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: storage-service
 * @description: Order
 * @author: loulvlin
 * @create: 2020-05-06 14:16
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("order_tbl")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value ="id",type = IdType.AUTO)
    private Integer id;
    private String userId;
    private String commodityCode;
    private Integer money;
    private Integer count;

}
