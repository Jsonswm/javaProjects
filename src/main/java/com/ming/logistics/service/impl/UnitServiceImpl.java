package com.ming.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.logistics.mapper.UnitMapper;
import com.ming.logistics.pojo.Unit;
import com.ming.logistics.service.UnitService;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements  UnitService{
}
