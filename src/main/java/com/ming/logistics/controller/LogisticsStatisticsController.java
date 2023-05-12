package com.ming.logistics.controller;

import com.ming.logistics.service.DeliveryService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@CrossOrigin
public class LogisticsStatisticsController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public Result statisticsLogistics(){


        return Result.success();
    }
}
