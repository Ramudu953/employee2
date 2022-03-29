package com.example.employee2.model;

import java.util.List;

public class EmployeeModel {
    private Employee employee;
    private EmployeeAddress employeeAddress;
    private EmployeeSalary employeeSalary;
    private List<EmployeeAttendance> employeeAttendances;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeAddress getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddress employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public EmployeeSalary getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(EmployeeSalary employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public List<EmployeeAttendance> getEmployeeAttendances() {
        return employeeAttendances;
    }

    public void setEmployeeAttendances(List<EmployeeAttendance> employeeAttendances) {
        this.employeeAttendances = employeeAttendances;
    }
}
