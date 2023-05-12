package com.ming.logistics.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit {
  private long id;
  private String unitSerial;
  private String unitName;
  private String unitDescription;

}
