package com.demo.spring.test.demoApp.services;

import com.demo.spring.test.demoApp.domain.Customer;

import java.util.List;


public interface CustomerService {

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);

    void addCustomer(Customer customer);

    void deleteCustomer(Long id);
}
