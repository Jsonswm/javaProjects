package com.ming.logistics.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ming.logistics.pojo.Car;
import com.ming.logistics.pojo.Unit;
import com.ming.logistics.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto {
    private Integer id;
    private String deliverySerial;
    private String deliveryImg;
    private String deliveryName;
    private long deliveryState;
    private String account;
    private Unit unit;
    private User user;
    private Car car;
}
