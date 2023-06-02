package com.ming.logistics.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ming.logistics.dto.ClassifyByDeliveryStateDto;
import com.ming.logistics.dto.DeliveryDto;
import com.ming.logistics.pojo.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeliveryMapper extends BaseMapper<Delivery> {

    List<ClassifyByDeliveryStateDto> statisticsByDelivery(String account);

    List<DeliveryDto> getDeliveryInfo();
}
