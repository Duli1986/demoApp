package com.demo.spring.test.demoApp.services;

import com.demo.spring.test.demoApp.domain.Customer;

import java.util.List;

public interface CustmerService {

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();
}
