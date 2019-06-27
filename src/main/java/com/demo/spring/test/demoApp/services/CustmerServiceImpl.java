package com.demo.spring.test.demoApp.services;

import com.demo.spring.test.demoApp.domain.Customer;
import com.demo.spring.test.demoApp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustmerServiceImpl implements CustomerService {



    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAllCustomers() {

        List<Customer> allCustomers = customerRepository.findAll().stream().collect(Collectors.toList());

        return allCustomers;
    }


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {

        List<Customer> allCustomerWithName = findAllCustomers()
                .stream()
                .filter(x -> x.getFirstName().equals(name))
                .collect(Collectors.toList());

        return allCustomerWithName;
    }


}
