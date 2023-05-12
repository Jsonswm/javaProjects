package com.ming.logistics.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private int departmentSerial;
  private String departmentName;

}
