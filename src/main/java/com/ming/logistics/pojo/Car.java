package com.ming.logistics.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car{

  @TableId(type = IdType.AUTO)
  private Integer id;
  private int carSerial;
  private String carImg;
  private String carType;
  private String carStatus;

}
