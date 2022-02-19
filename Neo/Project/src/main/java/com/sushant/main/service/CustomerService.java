package com.sushant.main.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.main.repository.CustomerRepository;

@Service
public class CustomerService {
      private final CustomerRepository customerRepository;

      @Autowired
	  public CustomerService(CustomerRepository customerRepository) {	
		this.customerRepository = customerRepository;
	  }

	 public String[] getMailAfterSevenDay() {
        return customerRepository.getCustomer().stream().map(e->e.getEmail()).collect(Collectors.toList()).toArray(String[]::new);
    }

}
