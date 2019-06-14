package com.demo.spring.test.demoApp.services;

import com.demo.spring.test.demoApp.DAO.ICustomerDao;
import com.demo.spring.test.demoApp.domain.Customer;
import com.demo.spring.test.demoApp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustmerServiceImpl implements CustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private CustomerRepository customerRepository;

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

    @Override
    public int addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
