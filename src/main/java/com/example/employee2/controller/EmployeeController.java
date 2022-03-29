package com.example.employee2.controller;

import com.example.employee2.entity.EmployeeDetails;
import com.example.employee2.model.EmployeeModel;
import com.example.employee2.model.EmployeeOffDays;
import com.example.employee2.model.EmployeeReport;
import com.example.employee2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/get/employee",method = RequestMethod.GET)
    public List<EmployeeModel> getEmployee(EmployeeDetails employee){
        return employeeService.getEmployee();
    }
    @RequestMapping(value = "/add/employee",method = RequestMethod.POST)
    public EmployeeDetails add(@RequestBody EmployeeModel employee){
        return employeeService.addEmployeeDetails(employee);
    }

    @RequestMapping(value = "/get/country/{country}",method = RequestMethod.GET)
    public Set<EmployeeModel> get(@PathVariable String country){
        return employeeService.getCountry(country);
    }
    @RequestMapping(value = "/get/city/{city1}/{city2}",method = RequestMethod.GET)
    public Set<EmployeeModel> getEmployeeByCity(@PathVariable String city1, @PathVariable String city2){
        return  employeeService.getCity(city1,city2);
    }
    @RequestMapping(value = "/get/{city}/{country}",method = RequestMethod.GET)
    public Set<EmployeeModel> getEmployeeByCityAndCountry(@PathVariable String city, @PathVariable String country){
        return  employeeService.getCityAndCountry(city,country);
    }
    @RequestMapping(value = "/get/salary",method = RequestMethod.GET)
    public List<EmployeeReport> getEmployeeSalaryDetails(){
        return employeeService.getEmployeeSalary();
    }
    @GetMapping("/salary/{payable}")
    public List<EmployeeReport> getEmployeeSalaryDetails(@PathVariable String payable){
        return employeeService.getSalaryPayable(payable);
    }
    @GetMapping("/attend/{date}")
    public List<EmployeeOffDays> getEmployeeAttend(@PathVariable String date){
        return employeeService.getEmployeeOffDays(date);
    }










}
