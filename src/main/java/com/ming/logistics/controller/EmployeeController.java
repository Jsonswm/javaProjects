package com.ming.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ming.logistics.dto.ClassifyByDepartmentDto;
import com.ming.logistics.dto.ClassifyProfessionalDto;
import com.ming.logistics.mapper.EmployeeMapper;
import com.ming.logistics.pojo.Department;
import com.ming.logistics.pojo.Employee;
import com.ming.logistics.service.EmployeeService;
import com.ming.logistics.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:  * @param null
 * @return: Result
 * @author: swm
 * @time: 2023/3/15 23:28
 */
@Slf4j
@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    QueryWrapper<Employee> employeeQueryWrapper = new QueryWrapper<>();
    //查询在同一部门的员工
    /**
     * @description:  * @param dId
     * @return: com.ming.logistics.utils.Result
     * @author: swm
     * @time: 2023/3/16 0:25
     */
    @GetMapping ("/queryByDepartmentType")
    public Result queryByDepartmentType(int dId){
        employeeQueryWrapper.eq("d_id",dId);
        List<Employee> employees = employeeMapper.selectList(employeeQueryWrapper);
//        System.out.println(employees);
        return Result.success(employees);
    }

   /**
    * @description: 多表查询(员工表，部门表，职称表)
    * @param:
    * @return: com.ming.logistics.utils.Result
    * @author swm
    * @date: 2023/3/16 13:57
    */
    @GetMapping
    public PageInfo<Employee> queryAll(@RequestParam(value = "page",defaultValue = "1") Integer currentPage,@RequestParam(value = "size", defaultValue = "10") Integer pageSize){

        PageHelper.startPage(currentPage,pageSize);

        List<Employee> employeeList = employeeService.queryAll();

        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);

        return pageInfo;
    }



    /**
     * @description: 增加员工
     * @param: employee
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/16 9:25
     */
    @PostMapping
    public Result add(@RequestBody Employee employee){
//        Department department = employee.getDepartment();
        return Result.success(employeeService.save(employee));
    }

    /**
     * @description: 根据员工id删除
     * @param: id
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/16 9:25
     */
    @DeleteMapping
    public Result delete(int id){
        return Result.success(employeeService.removeById(id));
    }


    /**
     * @description: 获取所有驾驶员信息
     * @param:
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/19 23:50
     */
    @GetMapping("/queryDrivers")
    public Result queryDrivers(){

        List<Employee> drivers = employeeMapper.queryDrivers();

        return Result.success(drivers);
    }


    /**
     * @description: 根据用户输入信息进行模糊查询
     * @param: info
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/22 23:13
     */
    @GetMapping("/queryEmployeeByLike")
    public Result queryEmployeeByLike(String info){
        return Result.success(employeeMapper.searchEmployeeByLike(info));
    }


    /**
     * @description: 修改员工信息
     * @param: employee
     * @return: com.ming.logistics.utils.Result
     * @author swm
     * @date: 2023/3/24 17:47
     */
    @PutMapping
    public Result updateEmployee(@RequestBody Employee employee){
        return Result.success(employeeService.updateById(employee));
    }

    @GetMapping("/classifyByDepartment")
    public Result classifyByDepartment(){
        List<ClassifyByDepartmentDto> classifyByDepartments = employeeMapper.analysisEmployeeCountByDepartment();
        return Result.success(classifyByDepartments);
    }

    @GetMapping("/classifyByPro")
    public Result classifyByPro(){
        List<ClassifyProfessionalDto> classifyProfessionalDtos =employeeMapper.analysisEmployeeCountByProfessional();
        return Result.success(classifyProfessionalDtos);
    }

}
