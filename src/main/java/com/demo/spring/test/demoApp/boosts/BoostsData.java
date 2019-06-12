package com.demo.spring.test.demoApp.boosts;

import com.demo.spring.test.demoApp.domain.Customer;
import com.demo.spring.test.demoApp.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BoostsData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BoostsData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(" Loading Customer Data");

        Customer c1 = new Customer();
        c1.setFirstName("Martin");
        c1.setLastName("Dulovec");
        customerRepository.save(c1);


        Customer c2 = new Customer();
        c1.setFirstName("Martin");
        c1.setLastName("Simek");
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c1.setFirstName("Jiri");
        c1.setLastName("Sochor");
        customerRepository.save(c3);


        System.out.println("Customers Saved: " + customerRepository.count());
    }
}
