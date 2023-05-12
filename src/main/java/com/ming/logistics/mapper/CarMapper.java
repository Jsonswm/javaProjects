package com.ming.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ming.logistics.pojo.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CarMapper extends BaseMapper<Car> {
}
