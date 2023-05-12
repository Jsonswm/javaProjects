package com.ming.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ming.logistics.dto.GoodsAnalysisByMonthDto;
import com.ming.logistics.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    List<Goods> analysisElectronic();

    List<Goods> analysisWater();

    List<Goods> analysisFoods();

    List<Goods> analysisFruit();

    List<Goods> analysisCondiment();

    List<Goods> analysisWine();

    List<Goods> analysisDrink();

    List<GoodsAnalysisByMonthDto> analysisByMonth(String startTime, String endTime);

    List<GoodsAnalysisByMonthDto> analysisByAll();

    List<GoodsAnalysisByMonthDto> analysisByAllOutStore();

    List<GoodsAnalysisByMonthDto> analysisByMonthOutStore(String startTime, String endTime);


}
