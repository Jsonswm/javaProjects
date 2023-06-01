package com.ming.logistics.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ming.logistics.pojo.Unit;
import com.ming.logistics.service.UnitService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unit")
@CrossOrigin
public class UnitController {

    @Autowired
    private UnitService unitService;


    @GetMapping
    public Page<Unit> getAllUnits(Integer currentPage, Integer pageSize){

        Page<Unit> unitPage = new Page<>(currentPage,pageSize);
        return unitService.page(unitPage);
    }

    @GetMapping("/getUnits")
    public Result getAllUnits(){

        return Result.success(unitService.list());
    }


    @PostMapping
    public Result addUnits(@RequestBody Unit unit){
        return Result.success(unitService.save(unit));
    }

    @PutMapping
    public Result updateUnit(@RequestBody Unit unit){
        return Result.success(unitService.updateById(unit));
    }

    @DeleteMapping
    public Result updateUnit(int id){
        return Result.success(unitService.removeById(id));
    }
}
