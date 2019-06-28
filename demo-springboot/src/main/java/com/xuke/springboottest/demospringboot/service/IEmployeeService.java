package com.xuke.springboottest.demospringboot.service;

import com.xuke.springboottest.demospringboot.model.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAllEmployee();

    int updateEmployee();
}
