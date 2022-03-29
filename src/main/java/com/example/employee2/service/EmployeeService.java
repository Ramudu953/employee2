package com.example.employee2.service;

import com.example.employee2.entity.AddressDetails;
import com.example.employee2.entity.AttendanceDetails;
import com.example.employee2.entity.EmployeeDetails;
import com.example.employee2.entity.SalaryDetails;
import com.example.employee2.model.*;
import com.example.employee2.repository.AddressDetailsRepository;
import com.example.employee2.repository.AttendanceDetailsRepository;
import com.example.employee2.repository.EmployeeDetailsRepository;
import com.example.employee2.repository.SalaryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;
    @Autowired
    private AddressDetailsRepository addressDetailsRepository;
    @Autowired
    private SalaryDetailsRepository salaryDetailsRepository;
    @Autowired
    private AttendanceDetailsRepository attendanceDetailsRepository;

    public EmployeeModel getEmployeeModel(EmployeeDetails employeeDetails){
        EmployeeModel employeeModel = new EmployeeModel();
        Employee employee = new Employee();
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());

        EmployeeAddress employeeAddress = new EmployeeAddress();
        employeeAddress.setLine1(employeeDetails.getAddressDetails().getLine1());
        employeeAddress.setLine2(employeeDetails.getAddressDetails().getLine2());
        employeeAddress.setCity(employeeDetails.getAddressDetails().getCity());
        employeeAddress.setCountry(employeeDetails.getAddressDetails().getCountry());
        employeeAddress.setPhoneNumber(employeeDetails.getAddressDetails().getPhoneNumber());

        EmployeeSalary employeeSalary = new EmployeeSalary();
        employeeSalary.setSalary(employeeDetails.getSalaryDetails().getSalary());
        employeeSalary.setPayable(employeeDetails.getSalaryDetails().getPayable());

        List<EmployeeAttendance> employeeAttendances = new ArrayList<>();
        employeeDetails.getAttendanceDetailsList().stream().forEach(atd->{
            EmployeeAttendance atd2 = new EmployeeAttendance();
            atd2.setDate(atd.getDate());
            atd2.setHoliday(atd.isHoliday());
            atd2.setReasonForHoliday(atd.getReasonForHoliday());
            employeeAttendances.add(atd2);
        });

        employeeModel.setEmployee(employee);
        employeeModel.setEmployeeAddress(employeeAddress);
        employeeModel.setEmployeeSalary(employeeSalary);
        employeeModel.setEmployeeAttendances(employeeAttendances);

        return employeeModel;

    }

    public List<EmployeeModel> getEmployee(){
        List<EmployeeDetails> employeeDetails = employeeDetailsRepository.findAll();
        return employeeDetails.stream().map(emp->getEmployeeModel(emp)).collect(Collectors.toList());
    }


    public EmployeeDetails addEmployeeDetails(EmployeeModel employeeModel){
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setName(employeeModel.getEmployee().getName());
        employeeDetails.setEmail(employeeModel.getEmployee().getEmail());
        employeeDetailsRepository.save(employeeDetails);

        AddressDetails addressDetails = new AddressDetails();
        addressDetails.setLine1(employeeModel.getEmployeeAddress().getLine1());
        addressDetails.setLine2(employeeModel.getEmployeeAddress().getLine2());
        addressDetails.setCity(employeeModel.getEmployeeAddress().getCity());
        addressDetails.setCountry(employeeModel.getEmployeeAddress().getCountry());
        addressDetails.setPhoneNumber(employeeModel.getEmployeeAddress().getPhoneNumber());
        addressDetailsRepository.save(addressDetails);
        addressDetails.setEmployeeDetails(employeeDetails);

        SalaryDetails salaryDetails = new SalaryDetails();
        salaryDetails.setSalary(employeeModel.getEmployeeSalary().getSalary());
        salaryDetails.setPayable(employeeModel.getEmployeeSalary().getPayable());
        salaryDetailsRepository.save(salaryDetails);
        salaryDetails.setEmployeeDetails(employeeDetails);

        List<AttendanceDetails> attendanceDetailsList = new ArrayList<>();
        employeeModel.getEmployeeAttendances().stream().forEach(atd->{
            AttendanceDetails atd2 = new AttendanceDetails();
            atd2.setDate(atd.getDate());
            atd2.setHoliday(atd.isHoliday());
            atd2.setReasonForHoliday(atd.getReasonForHoliday());
            atd2.setEmployeeDetails(employeeDetails);
            attendanceDetailsRepository.save(atd2);
            attendanceDetailsList.add(atd2);
        });
        employeeDetails.setAddressDetails(addressDetails);
        employeeDetails.setSalaryDetails(salaryDetails);
        employeeDetails.setAttendanceDetailsList(attendanceDetailsList);

        return employeeDetailsRepository.save(employeeDetails);
    }





    //Task1
    public Set<EmployeeModel> getCountry(String country){
        List<AddressDetails> ad = addressDetailsRepository.findByCountryIgnoreCase(country);
        Set<EmployeeDetails> ed = ad.stream().
                map(AddressDetails::getEmployeeDetails).collect(Collectors.toSet());
        return  ed.stream().map(this::getEmployeeModel).collect(Collectors.toSet());
    }

    //Task2
    public Set<EmployeeModel> getCity(String city1, String city2){
        List<AddressDetails> ad = addressDetailsRepository.findByCityOrCityIgnoreCase(city1,city2);
        Set<String> s = ad.stream().
                map(AddressDetails::getEmployeeDetails).
                map(EmployeeDetails::getId).collect(Collectors.toSet());
        return   s.stream().map(emp -> employeeDetailsRepository.findById(emp).orElse(null)).
                map(this::getEmployeeModel).collect(Collectors.toSet());
    }

    //Task3
    public Set<EmployeeModel> getCityAndCountry(String city, String country){
        List<AddressDetails> a = addressDetailsRepository.findByCityAndCountryIgnoreCase(city,country);
        return   a.stream().map(AddressDetails::getEmployeeDetails).map(this::getEmployeeModel).collect(Collectors.toSet());
    }

    //Task4
    public List<EmployeeReport> getEmployeeSalary(){
        List<EmployeeDetails> ed = employeeDetailsRepository.findAll();
        return ed.stream().map(this::getEmployeeWithSalary).collect(Collectors.toList());
    }
    public EmployeeReport getEmployeeWithSalary(EmployeeDetails employeeDetails){
        return new EmployeeReport(employeeDetails.getId(),employeeDetails.getName(),
                employeeDetails.getEmail(),employeeDetails.getSalaryDetails().getSalary(),
                employeeDetails.getSalaryDetails().getPayable());
    }


    //Task5
    public List<EmployeeReport> getSalaryPayable(String payable){
        List<SalaryDetails> salaryDetails = salaryDetailsRepository.
                findByPayableIgnoreCaseContaining(payable);
        List<EmployeeDetails> employeeDetails = salaryDetails.stream().
                map(SalaryDetails::getEmployeeDetails).collect(Collectors.toList());
        return employeeDetails.stream().
                map(this::getEmployeeWithSalary).collect(Collectors.toList());
    }



    //Task6
    public List<EmployeeOffDays> getEmployeeOffDays(String date){
        List<AttendanceDetails> attendanceDetailsList = attendanceDetailsRepository.findByDateContains(date);
        List<AttendanceDetails> ad = attendanceDetailsRepository.findByHolidayTrue();
        List<String> emp = ad.stream().
               map(AttendanceDetails::getEmployeeDetails).map(EmployeeDetails::getId).collect(Collectors.toList());
        List<Integer> size = new ArrayList<>();
        ad.forEach(var->{
            List<AttendanceDetails> atd = ad.
                    stream().
                    filter(a->a.getDate().endsWith(date)).
                    filter(at1->at1.getEmployeeDetails().getId().equalsIgnoreCase(String.valueOf(var))).
                    collect(Collectors.toList());
        });
        List<AttendanceDetails> empAtt = ad.stream().filter(AttendanceDetails::isHoliday).collect(Collectors.toList());
        List<EmployeeDetails> e = emp.stream().map(em->employeeDetailsRepository.findById(em).orElse(null)).collect(Collectors.toList());
        List<EmployeeOffDays> efd = new ArrayList<>();
        AtomicInteger i = new AtomicInteger();
        e.forEach(a-> {
            EmployeeOffDays employeeOffDays = new EmployeeOffDays(
                    a.getId(),a.getName(),
                    a.getAddressDetails().getPhoneNumber(),
                    a.getSalaryDetails().getSalary(),size.get(i.getAndIncrement()));
            efd.add(employeeOffDays);
        });
        return efd;
    }



}
