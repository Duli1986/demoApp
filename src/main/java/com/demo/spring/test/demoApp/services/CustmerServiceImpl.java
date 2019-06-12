package com.demo.spring.test.demoApp.services;

import com.demo.spring.test.demoApp.domain.Customer;
import com.demo.spring.test.demoApp.repositories.CustomerRepository;

import java.util.List;

public class CustmerServiceImpl implements CustmerService {

    private final CustomerRepository customerRepository;

    public CustmerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
