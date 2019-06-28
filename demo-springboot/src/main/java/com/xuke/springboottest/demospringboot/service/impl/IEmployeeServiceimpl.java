package com.xuke.springboottest.demospringboot.service.impl;

import com.xuke.springboottest.demospringboot.mapper.EmployeeMapper;
import com.xuke.springboottest.demospringboot.model.Employee;
import com.xuke.springboottest.demospringboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IEmployeeServiceimpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public List<Employee> getAllEmployee() {
        //redis中获取
        List<Employee> employeeList = (List<Employee>) redisTemplate.opsForValue().get("allEmpl");
        //缓存中没有 就加锁同步一下 让第一个线程去查数据库，其他线程都走缓存  避免缓存穿透
        if (employeeList == null) {
            synchronized (this) {
                employeeList = (List<Employee>) redisTemplate.opsForValue().get("allEmpl");
                if (employeeList == null) {
                    employeeList = employeeMapper.getAllEmployee();
                    redisTemplate.opsForValue().set("allEmpl", employeeList);
                }
            }
        }
        return employeeList;
    }

    @Override
    @Transactional//开启事务
    public int updateEmployee() {
        Employee employee = new Employee();
        employee.setId(6L);
        employee.setRealname("朱宽阔");
        int update = employeeMapper.updateByPrimaryKeySelective(employee);

        int i = 1 / 0;
        System.out.println(update);
        return update;
    }
}
