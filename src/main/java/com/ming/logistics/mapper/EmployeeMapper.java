package com.ming.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ming.logistics.dto.ClassifyByDepartmentDto;
import com.ming.logistics.dto.ClassifyProfessionalDto;
import com.ming.logistics.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * @description: 查询所有的员工（联合查询）
     * @param:
     * @return: java.util.List<com.ming.logistics.pojo.Employee>
     * @author swm
     * @date: 2023/3/26 18:15
     */
    List<Employee> queryAll();

    /**
     * @description: 查询所有的驾驶员
     * @param:
     * @return: java.util.List<com.ming.logistics.pojo.Employee>
     * @author swm
     * @date: 2023/3/26 18:16
     */
    List<Employee> queryDrivers();

    /**
     * @description: 根据部门进行分类
     * @param:
     * @return: java.util.List<com.ming.logistics.dto.ClassifyByDepartmentDto>
     * @author swm
     * @date: 2023/3/26 18:16
     */
    List<ClassifyByDepartmentDto> analysisEmployeeCountByDepartment();

    /**
     * @description: 根据职位进行分类
     * @param:
     * @return: java.util.List<com.ming.logistics.pojo.Employee>
     * @author swm
     * @date: 2023/3/26 18:17
     */
    List<ClassifyProfessionalDto> analysisEmployeeCountByProfessional();

    List<Employee> searchEmployeeByLike(String info);

}

