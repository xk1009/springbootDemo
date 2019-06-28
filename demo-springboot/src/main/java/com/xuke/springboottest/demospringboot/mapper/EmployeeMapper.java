package com.xuke.springboottest.demospringboot.mapper;

import com.xuke.springboottest.demospringboot.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getAllEmployee();
}