package com.demo.spring.test.demoApp.services;

import com.demo.spring.test.demoApp.domain.Customer;
import com.demo.spring.test.demoApp.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustmerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustmerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
