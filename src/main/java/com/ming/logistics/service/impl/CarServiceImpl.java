package com.ming.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.logistics.mapper.CarMapper;
import com.ming.logistics.service.CarService;
import com.ming.logistics.pojo.Car;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
}
