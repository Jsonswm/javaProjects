package com.ming.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ming.logistics.pojo.Department;
import com.ming.logistics.service.DepartmentService;
import com.ming.logistics.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public Result queryAll(){
        return Result.success(departmentService.list());
    }

    @RequestMapping("/queryByType")
    public Result queryByType(String departmentName){
        QueryWrapper<Department> departmentQueryWrapper = new QueryWrapper<>();
        departmentQueryWrapper.eq("department_name",departmentName);
        return Result.success(departmentService.list(departmentQueryWrapper));
    }


}
