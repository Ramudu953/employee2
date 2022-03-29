package com.example.employee2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "attendance_details")
public class AttendanceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String date;
    @Column
    private boolean holiday;
    @Column
    private String reasonForHoliday;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    //@JoinColumn(name = "employee_details_id")
    private EmployeeDetails employeeDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public String getReasonForHoliday() {
        return reasonForHoliday;
    }

    public void setReasonForHoliday(String reasonForHoliday) {
        this.reasonForHoliday = reasonForHoliday;
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }
}
