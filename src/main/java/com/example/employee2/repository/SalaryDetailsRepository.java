package com.example.employee2.repository;

import com.example.employee2.entity.SalaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryDetailsRepository extends JpaRepository<SalaryDetails,String> {
    List<SalaryDetails> findByPayableIgnoreCaseContaining(String payable);
}
