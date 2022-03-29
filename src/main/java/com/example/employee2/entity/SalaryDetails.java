package com.example.employee2.entity;

import com.example.employee2.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "salary_details")
public class SalaryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private int salary;
    @Column
    private String payable;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    //@JoinColumn(name = "employee_details_id")
    private EmployeeDetails employeeDetails;

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPayable() {
        return payable;
    }

    public void setPayable(String payable) {
        this.payable = payable;
    }


}
