package com.example.employee2.repository;

import com.example.employee2.entity.EmployeeDetails;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails,String> {
}
