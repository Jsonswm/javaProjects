package com.ming.logistics.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.logistics.dto.GoodsDto;
import com.ming.logistics.mapper.GoodsMapper;
import com.ming.logistics.pojo.Goods;
import com.ming.logistics.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.*;

@RestController
@RequestMapping("/goodsTypeAnalysis")
@CrossOrigin
public class GoodsAnalysisController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @description: 获取电子产品的占比
     * @param:
     * @return: java.lang.String
     * @author swm
     * @date: 2023/3/17 22:29
     */
    @GetMapping
    public List<GoodsDto> countGoodsType(){
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.lambda().isNotNull(Goods::getGoodsType);
        List<Goods> goodsList = goodsMapper.selectList(goodsQueryWrapper);
        /**
         * @description: 商品总数
         * @param:
         * @return: java.util.List<com.ming.logistics.dto.GoodsDto>
         * @author swm
         * @date: 2023/3/22 13:13
         */
        int count = goodsList.size();


        //电子产品类型总数及占比
        List<Goods> electronicList = goodsMapper.analysisElectronic();
        int electronic = electronicList.size();

        DecimalFormat decimalFormat = new DecimalFormat();
        String proportionOfElectronic= decimalFormat.format((float)electronic/count);


        //水产品总数及占比
        List<Goods> waterList = goodsMapper.analysisWater();
        int water=waterList.size();
        String proportionOfWater = decimalFormat.format((float)water/count);


        //食品占比
        List<Goods> foodList = goodsMapper.analysisFoods();
        int food = foodList.size();
        String proportionOfFood= decimalFormat.format((float)food/count);

        //饮料占比
        List<Goods> drinkList = goodsMapper.analysisDrink();
        int drink = drinkList.size();

        String proportionOfDrink= decimalFormat.format((float)drinkList.size()/count);
//        System.out.println(proportionOfDrink);
        //调味料占比
        List<Goods> condimentList = goodsMapper.analysisCondiment();
        int condiment = condimentList.size();
        String proportionOfCondiment= decimalFormat.format((float)condimentList.size()/count);

        //水果占比
        List<Goods> fruitList = goodsMapper.analysisFruit();
        int fruit = fruitList.size();
        String proportionOfFruit= decimalFormat.format((float)fruitList.size()/count);


        //酒类占比
        List<Goods> wineList = goodsMapper.analysisWine();
        int wine = wineList.size();
        String proportionOfWine= decimalFormat.format((float)wine/count);


        System.out.println(count);

        //存储各类型商品占比(key唯一，value可以相同)
        HashMap<String,String> hashMap = new HashMap<>();

        hashMap.put("电子产品",proportionOfElectronic);
        hashMap.put("水产品",proportionOfWater);
        hashMap.put("酒水",proportionOfWine);
        hashMap.put("水果",proportionOfFruit);
        hashMap.put("调味料",proportionOfCondiment);
        hashMap.put("饮料",proportionOfDrink);
        hashMap.put("食品",proportionOfFood);

        Iterator<String> iterator = hashMap.keySet().iterator();
        List<GoodsDto> goodsDtoList = new ArrayList<>();
        while (iterator.hasNext()){
            String  name = iterator.next();
            String value = hashMap.get(name);
            GoodsDto goodsDto = new GoodsDto(name,value);
            System.out.println(goodsDto);
            goodsDtoList.add(goodsDto);
        }
        return goodsDtoList;
    }


}
