package com.xuke.springboottest.demospringboot.controller;

import com.xuke.springboottest.demospringboot.model.Employee;
import com.xuke.springboottest.demospringboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/getAllEmployee")
    public Map<String,Object> getAllEmployee(){
        Map<String,Object> result = new HashMap<>();


        List<Employee> allEmployee = iEmployeeService.getAllEmployee();
        result.put("allEmployee",allEmployee);
        return result;
    }

    @GetMapping("/update")
    public Object update(){
        return iEmployeeService.updateEmployee();
    }
}
