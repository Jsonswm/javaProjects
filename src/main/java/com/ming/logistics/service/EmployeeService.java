package com.ming.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ming.logistics.pojo.Employee;

import java.util.List;


public interface EmployeeService extends IService<Employee> {

    /**
     * @description: 分页查询
     * @param:
     * @return: java.util.List<com.ming.logistics.pojo.Employee>
     * @author swm
     * @date: 2023/6/1 9:33
     */
    List<Employee> queryAll();


}
