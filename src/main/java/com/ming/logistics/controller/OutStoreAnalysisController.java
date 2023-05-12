package com.ming.logistics.controller;


import com.ming.logistics.dto.GoodsAnalysisByMonthDto;
import com.ming.logistics.mapper.GoodsMapper;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("outStoreAnalysis")
@CrossOrigin
public class OutStoreAnalysisController {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @description: 分析用户输入区间数据
     * @param: startTime,endTime
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/4/8 20:35
     */
    @GetMapping("/analysisByMonth")
    public Result analysisByMonth(String startTime, String endTime){
        List<GoodsAnalysisByMonthDto> goodsAnalysisByMonthDtoList = goodsMapper.analysisByMonthOutStore(startTime,endTime);
        return Result.success(goodsAnalysisByMonthDtoList);
    }



    /**
     * @description: 分析所有出库数据
     * @param:
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/4/8 20:35
     */
    @GetMapping("/analysisByAll")
    public Result analysisByAll(){
        List<GoodsAnalysisByMonthDto> goodsAnalysisByMonthDtoList = goodsMapper.analysisByAllOutStore();
        return Result.success(goodsAnalysisByMonthDtoList);
    }
}
