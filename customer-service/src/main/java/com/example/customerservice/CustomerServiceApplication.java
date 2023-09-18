package com.example.customerservice;

import com.example.customerservice.models.Customer;
import com.example.customerservice.repostitories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                customerRepository.save(Customer.builder()
                        .name("Customer" + i)
                        .email("cust" + i + "@gmail.com")
                        .build());
            }
        };
    }
}
