package com.example.employee2.repository;

import com.example.employee2.entity.AddressDetails;
import com.example.employee2.entity.AttendanceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceDetailsRepository extends JpaRepository<AttendanceDetails,String> {
    List<AttendanceDetails> findByDateContains(String date);

    List<AttendanceDetails> findByHolidayTrue();
}
