package com.ming.logistics.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String deliverySerial;
  private String deliveryImg;
  private String deliveryName;
  private long deliveryState;
  private String account;
  private int unitId;
  private int userId;
  private int carId;
}
