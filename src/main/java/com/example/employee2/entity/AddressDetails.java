package com.example.employee2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "address_details")
public class AddressDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String line1;
    @Column
    private String line2;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private Long phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
   // @JoinColumn(name = "employee_details_id")
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

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
