package com.ming.logistics.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private int employeeSerial;
  private String employeeName;
  private String employeeGender;
  private int employeeAge;
  private int dId;
  private int pId;
  @TableField(exist = false)
  private Department department;
  @TableField(exist = false)
  private Professional professional;
}
