package com.ming.logistics.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.logistics.mapper.GoodsMapper;
import com.ming.logistics.pojo.Goods;
import com.ming.logistics.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
