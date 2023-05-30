package com.ming.logistics.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.logistics.dto.ClassifyByDeliveryStateDto;
import com.ming.logistics.mapper.DeliveryMapper;
import com.ming.logistics.pojo.Delivery;
import com.ming.logistics.service.DeliveryService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/delivery")
@CrossOrigin
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private DeliveryMapper deliveryMapper;

    /**
     * @description: 查询所有订单
     * @param:
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/30 8:21
     */
    @GetMapping
    public Result queryAll() {
        QueryWrapper<Delivery> deliveryQueryWrapper = new QueryWrapper<>();

        deliveryQueryWrapper.eq("delivery_state", 0)
                .or().eq("delivery_state", 1);
//                .or().eq("delivery_state", 2);
        return Result.success(deliveryService.list(deliveryQueryWrapper));
    }

    @GetMapping("/queryOrderInDelivery")
    public Result queryOrderInDelivery() {
        QueryWrapper<Delivery> deliveryQueryWrapper = new QueryWrapper<>();
        deliveryQueryWrapper.eq("delivery_state", 2);
        return Result.success(deliveryService.list(deliveryQueryWrapper));
    }

    @GetMapping("/queryOrderAccomplish")
    public Result queryOrderAccomplish() {
        QueryWrapper<Delivery> deliveryQueryWrapper = new QueryWrapper<>();
        deliveryQueryWrapper.eq("delivery_state", 3);
        return Result.success(deliveryService.list(deliveryQueryWrapper));
//        return Result.success();
    }

    /**
     * @description: 查询管理员搜索的未配送的订单
     * @param: searchInfo
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/4/7 14:03
     */
    @GetMapping("/queryOrders")
    public Result queryOrders(String searchInfo) {
        QueryWrapper<Delivery> deliveryQueryWrapper = new QueryWrapper<>();
        deliveryQueryWrapper.like("delivery_name", searchInfo)
                .eq("delivery_state", 0)
                .or().like("delivery_name", searchInfo).eq("delivery_state",1);
        return Result.success(deliveryService.list(deliveryQueryWrapper));
    }

    /**
     * @description: 配送列表查询
     * @param: searchInfo
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/4/7 16:31
     */
    @GetMapping("/queryOrdersInList")
    public Result queryOrdersInList(String searchInfo) {
        QueryWrapper<Delivery> deliveryQueryWrapper = new QueryWrapper<>();
        deliveryQueryWrapper.like("delivery_name", searchInfo).eq("delivery_state", 2);
        return Result.success(deliveryService.list(deliveryQueryWrapper));
    }


    /**
     * @description: 个人物流查询
     * @param: account
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/4/8 11:30
     */
    @GetMapping("/getPersonalLogistics")
    public Result getPersonalLogistics(String account) {
        QueryWrapper<Delivery> deliveryQueryWrapper = new QueryWrapper<>();
        deliveryQueryWrapper.eq("account", account);
        return Result.success(deliveryService.list(deliveryQueryWrapper));
    }

    /**
     * @description: 用户物流状态分类查询
     * @param: account
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/4/8 18:22
     */
    @GetMapping("/statisticsByDeliveryState")
    public Result statisticsByDeliveryState(String account) {

        List<ClassifyByDeliveryStateDto> deliveryStateDto = deliveryMapper.statisticsByDelivery(account);

        return Result.success(deliveryStateDto);
    }

    /**
     * @description: 配送员订单配送查询
     * @param: account
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/4/13 21:07
     */
    @GetMapping("/queryDelivery")
    public Result queryDelivery(int id) {
        QueryWrapper<Delivery> deliveryQueryWrapper = new QueryWrapper<>();
        deliveryQueryWrapper.eq("user_id", id).eq("delivery_state", 1).or().eq("delivery_state", 2);
        return Result.success(deliveryService.list(deliveryQueryWrapper));
    }


    /**
     * @description: 添加订单
     * @param: delivery
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/30 8:21
     */
    @PostMapping
    public Result addDelivery(@RequestBody Delivery delivery) {
        return Result.success(deliveryService.save(delivery));
    }


    @PutMapping
    public Result updateDelivery(@RequestBody Delivery delivery) {
        return Result.success(deliveryService.updateById(delivery));
    }

    @DeleteMapping
    public Result deleteDelivery(int id) {
        return Result.success(deliveryService.removeById(id));
    }

}
