package com.ming.logistics.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String goodsName;
  private String goodsImg;
  private long goodsSerial;
  private String goodsType;
  private double goodsPrice;
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date inStoreTime;
  private Date outStoreTime;
  private long sId;
  private long uId;

}
