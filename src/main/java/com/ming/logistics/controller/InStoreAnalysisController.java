package com.ming.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.logistics.dto.GoodsAnalysisByMonthDto;
import com.ming.logistics.mapper.GoodsMapper;
import com.ming.logistics.pojo.Goods;
import com.ming.logistics.service.GoodsService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@CrossOrigin
@RequestMapping("/inStoreAnalysis")
public class InStoreAnalysisController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsMapper goodsMapper;



    @GetMapping
    public Result analysisInStore(String startTime,String endTime){
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.between("in_store_time",startTime,endTime);
        //月份区间的所有商品数据
        List<Goods> goodsList = goodsService.list(goodsQueryWrapper);

        return Result.success(goodsList);
    }



    @GetMapping("/inStoreAnalysisByMonth")
    public Result inStoreAnalysisByMonth(String startTime,String endTime){
        List<GoodsAnalysisByMonthDto> goodsAnalysisByMonthDtoList = goodsMapper.analysisByMonth(startTime,endTime);
        System.out.println(goodsAnalysisByMonthDtoList);
        return Result.success(goodsAnalysisByMonthDtoList);
    }



    @GetMapping("/inStoreAnalysisByAll")
    public Result inStoreAnalysisByAll(){
        List<GoodsAnalysisByMonthDto> goodsAnalysisByMonthDtoList = goodsMapper.analysisByAll();
        return Result.success(goodsAnalysisByMonthDtoList);
    }
}
