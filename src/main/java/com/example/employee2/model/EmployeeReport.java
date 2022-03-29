package com.example.employee2.model;

public class EmployeeReport {
    private String id,name,email;
    private int salary;
    private String payable;

    public EmployeeReport(String id, String name, String email, int salary, String payable) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.payable = payable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
