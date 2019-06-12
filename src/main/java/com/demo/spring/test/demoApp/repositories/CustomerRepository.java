package com.demo.spring.test.demoApp.repositories;

import com.demo.spring.test.demoApp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
