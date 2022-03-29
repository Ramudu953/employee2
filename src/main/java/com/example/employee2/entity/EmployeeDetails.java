package com.example.employee2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;
    @Column
    private String email;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employeeDetails")
    //@JoinColumn(name = "address_details_id")
    private AddressDetails addressDetails;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employeeDetails")
   // @JoinColumn(name = "salary_details_id")
    private SalaryDetails salaryDetails;
    @OneToMany(mappedBy = "employeeDetails")
    private List<AttendanceDetails> attendanceDetailsList;

    public SalaryDetails getSalaryDetails() {
        return salaryDetails;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
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

    public List<AttendanceDetails> getAttendanceDetailsList() {
        return attendanceDetailsList;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public void setSalaryDetails(SalaryDetails salaryDetails) {
        this.salaryDetails = salaryDetails;
    }

    public void setAttendanceDetailsList(List<AttendanceDetails> attendanceDetailsList) {
        this.attendanceDetailsList = attendanceDetailsList;
    }
}
