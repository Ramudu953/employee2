package com.example.employee2.repository;

import com.example.employee2.entity.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDetailsRepository extends JpaRepository<AddressDetails,String> {
    List<AddressDetails> findByCountryIgnoreCase(String country);

    List<AddressDetails> findByCityOrCityIgnoreCase(String city1, String city2);

    List<AddressDetails> findByCityAndCountryIgnoreCase(String city, String country);
}
