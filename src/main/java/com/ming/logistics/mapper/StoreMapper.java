package com.ming.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ming.logistics.pojo.Store;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreMapper extends BaseMapper<Store> {

}

