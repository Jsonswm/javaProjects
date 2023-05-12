package com.ming.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.logistics.mapper.DeliveryMapper;
import com.ming.logistics.pojo.Delivery;
import com.ming.logistics.service.DeliveryService;
import org.springframework.stereotype.Service;


@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {
}
