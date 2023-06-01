package com.ming.logistics.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ming.logistics.pojo.Store;
import com.ming.logistics.service.StoreService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@CrossOrigin
public class StoreController {

    //条件构造器
    QueryWrapper<Store> storeQueryWrapper = new QueryWrapper<>();

    @Autowired
    private StoreService storeService;

    //查询所有仓库信息
    @GetMapping()
    public Result list(Integer currentPage, Integer pageSize){

        Page<Store> storePage = new Page<>(currentPage,pageSize);
        Page<Store> storePage1 = storeService.page(storePage);
//        System.out.println(storeService.list());
        return Result.success(storePage1);
    }

    //增加仓库
    @PostMapping
    public Result add(@RequestBody Store store){
        System.out.println(store);

        return Result.success(storeService.save(store));
    }

    //通过仓库id进行删除
    @DeleteMapping("/removeById")
    public Result removeById(int id){
        return Result.success(storeService.removeById(id));
    }

    //通过仓库id进行修改
    @PutMapping("/updateById")
    public Result updateById(@RequestBody Store store){
        return Result.success(storeService.updateById(store));
    }

    //根据仓库名查找
    @GetMapping("/queryByName")
    public Result queryByName(String name){
        storeQueryWrapper.eq("store_name",name);
        System.out.println(name);
        return Result.success(storeService.getOne(storeQueryWrapper));
    }
}
