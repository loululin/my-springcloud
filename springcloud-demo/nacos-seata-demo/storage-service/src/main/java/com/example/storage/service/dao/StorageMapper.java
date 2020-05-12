package com.example.storage.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.storage.service.entity.Storage;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: aos-project
 * @description: StorageDAO
 * @author: loulvlin
 * @create: 2020-05-06 09:29
 **/
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
}
