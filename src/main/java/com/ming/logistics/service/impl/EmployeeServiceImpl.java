package com.ming.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.logistics.mapper.EmployeeMapper;
import com.ming.logistics.service.EmployeeService;
import com.ming.logistics.pojo.Employee;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
