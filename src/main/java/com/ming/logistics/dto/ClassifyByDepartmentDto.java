package com.ming.logistics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassifyByDepartmentDto  {
   private String departmentName;
   private int count;
}
