package com.ming.logistics.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ming.logistics.dto.DeliveryDto;
import com.ming.logistics.pojo.Delivery;
import com.ming.logistics.pojo.Employee;

import java.util.List;

public interface DeliveryService extends IService<Delivery> {

    /**
     * @description: 订单详情查询（分配配送相关信息）
     * @param:
     * @return: java.util.List<com.ming.logistics.dto.DeliveryDto>
     * @author swm
     * @date: 2023/6/2 18:51
     */
    List<DeliveryDto> getDeliveryInfo();
}
