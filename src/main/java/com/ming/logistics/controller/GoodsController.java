package com.ming.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ming.logistics.mapper.GoodsMapper;
import com.ming.logistics.pojo.Goods;
import com.ming.logistics.service.GoodsService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @description: 查询所有商品
     * @param:
     * @return: java.util.List<com.ming.logistics.pojo.Goods>
     * @author swm
     * @date: 2023/3/21 13:20
     */
    //查询所有商品
    @GetMapping
    public Page<Goods> queryAll(@RequestParam("currentPage") Integer page,@RequestParam("pageSize") Integer size) {
        Page<Goods> goodsPage = new Page<>(page,size);
//        LambdaQueryWrapper<Goods> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<Goods> page1 = goodsService.page(goodsPage);
        return page1;
    }

    /**
     * @description: 添加商品
     * @param: goods
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/21 13:20
     */
    //添加商品
    @PostMapping
    public Result insert(@RequestBody Goods goods) {
        return Result.toResult(goodsService.save(goods));
    }

    @DeleteMapping
    public Result delete(int id) {
        return Result.toResult(goodsService.removeById(id));
    }


    /**
     * @description: 修改商品信息
     * @param: goods
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/21 13:20
     */
    @PutMapping
    public Result update(@RequestBody Goods goods) {

        System.out.println(goods);
        return Result.success(goodsService.updateById(goods));
    }

    /**
     * @description: 根据输入信息进行模糊查询
     * @param: info
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/22 23:10
     */
    @GetMapping("/queryGoodsBySerial")
    public Result queryGoodsBySerial(String info) {
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.like("goods_serial", info);
        List<Goods> goodsList = goodsService.list(goodsQueryWrapper);
        System.out.println(goodsList);
        return Result.success(goodsList);
    }

    @GetMapping("/queryGoodsByName")
    public Result queryGoodsByName(String info) {
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.like("goods_name", info);
        List<Goods> goodsList = goodsService.list(goodsQueryWrapper);
        System.out.println(goodsList);
        return Result.success(goodsList);
    }


}
