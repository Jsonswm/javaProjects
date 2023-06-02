package com.ming.logistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.logistics.dto.DeliveryDto;
import com.ming.logistics.mapper.DeliveryMapper;
import com.ming.logistics.pojo.Delivery;
import com.ming.logistics.pojo.Employee;
import com.ming.logistics.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;


    @Override
    public List<DeliveryDto> getDeliveryInfo() {

        List<DeliveryDto> deliveryInfo = deliveryMapper.getDeliveryInfo();
        for (DeliveryDto deliveryDto: deliveryInfo){
            if (deliveryDto.getDeliveryState() == 2){
                List<DeliveryDto> deliveryDtos = new ArrayList<>();
                deliveryDtos.add(deliveryDto);
                System.out.println("info"+deliveryDto);
                return deliveryDtos;
            }
        }
        return null;
    }
}
