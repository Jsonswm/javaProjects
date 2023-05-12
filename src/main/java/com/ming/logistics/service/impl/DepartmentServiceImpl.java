package com.ming.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.logistics.mapper.DepartmentMapper;
import com.ming.logistics.mapper.EmployeeMapper;
import com.ming.logistics.service.DepartmentService;
import com.ming.logistics.pojo.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
