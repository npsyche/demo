package com.example.demo.web;

import com.example.demo.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Administrator on 2018/4/13.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("getEmployee")
    public Employee getEmployee(){
        Employee employee = new Employee();
        employee.setName("Susan");
        employee.setGender("Female");
        employee.setId("00001");
        employee.setCreateTime(new Date());
        return employee;
    }
}
