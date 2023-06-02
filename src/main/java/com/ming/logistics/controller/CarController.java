package com.ming.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ming.logistics.pojo.Car;
import com.ming.logistics.service.CarService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    QueryWrapper<Car> carQueryWrapper = new QueryWrapper<>();


    @PostMapping
    public Result addCar(@RequestBody Car car){
        return Result.success(carService.save(car));
    }
    //查询所有车辆所有信息
    @GetMapping
    public Page<Car> queryALl(Integer currentPage, Integer pageSize){
        Page<Car> page = new Page<>(currentPage,pageSize);
        return carService.page(page);
    }

    @GetMapping("/getCars")
    public Result getCars(){
        return Result.success(carService.list());
    }



    @GetMapping("/queryByType")
    public Result queryByType(String type){
        carQueryWrapper.like("car_type",type);
        return Result.success(carService.list(carQueryWrapper));
    }

    @GetMapping("/queryByStatus")
    public Result queryByStatus(long status){
        carQueryWrapper.eq("car_status",status);
        return Result.success(carService.list(carQueryWrapper));
    }

    @DeleteMapping
    public Result deleteByCatId(Integer id){
//        boolean i = carService.removeById(id);
        return Result.success(carService.removeById(id));
    }

    @PutMapping
    public Result updateCarById(@RequestBody Car car){
        return Result.success(carService.updateById(car));
    }
}
