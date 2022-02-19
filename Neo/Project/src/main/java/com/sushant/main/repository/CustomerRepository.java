package com.sushant.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sushant.main.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(value = "SELECT * FROM  customer WHERE  DATE_ADD(date_of_birth,INTERVAL YEAR(CURDATE())-YEAR(date_of_birth)+ IF(DAYOFYEAR(CURDATE()) > DAYOFYEAR(date_of_birth),1,0)YEAR)BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)", nativeQuery = true)
    List<Customer> getCustomer();
   
    @Query(value = "SELECT * FROM  customer WHERE  DATE_ADD(date_of_birth,INTERVAL YEAR(CURDATE())-YEAR(date_of_birth)+ IF(DAYOFYEAR(CURDATE()) > DAYOFYEAR(date_of_birth),1,0)YEAR)BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 DAY)", nativeQuery = true)
    List<Customer> getCustomersListOneDayBeforeBirthday();

}
