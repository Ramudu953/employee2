package com.example.employee2.model;

public class EmployeeOffDays {
    private String id,name;
    private long phoneNumber;
    private int salary;
    private int numberOfHolidays;

    public EmployeeOffDays(String id, String name, long phoneNumber, int salary, int numberOfHolidays) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.numberOfHolidays = numberOfHolidays;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getNumberOfHolidays() {
        return numberOfHolidays;
    }

    public void setNumberOfHolidays(int numberOfHolidays) {
        this.numberOfHolidays = numberOfHolidays;
    }
}
