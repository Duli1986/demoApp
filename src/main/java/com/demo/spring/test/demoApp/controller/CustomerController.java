package com.demo.spring.test.demoApp.controller;

import com.demo.spring.test.demoApp.domain.Customer;
import com.demo.spring.test.demoApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/getall")
    Iterable<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "/{id}")
    Customer getCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customer saveCustomer(@RequestBody Customer customer){

        return customerService.saveCustomer(customer);
    }

    @RequestMapping(value = "/addCustom")
    public String addCustomer(){
        Customer c1 =  new Customer();
            c1.setFirstName("Martin");
            c1.setLastName("Šimek");

        customerService.addCustomer(c1);

        return "success";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomer(id);

        return "customer deleted";
    }

    @DeleteMapping
    public String delete(@RequestBody Customer customer){

        customerService.deleteCustomer(customer.getId());

        return "customer deleted";
    }

    @GetMapping(value = "/getByName/{name}")
    Iterable<Customer> getAllCustomersByName(@PathVariable String name){

        return customerService.findCustomerByName(name);
    }




}
