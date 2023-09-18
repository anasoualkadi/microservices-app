package com.example.customerservice.controllers;

import com.example.customerservice.models.Customer;
import com.example.customerservice.repostitories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers/")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(null);

        return ResponseEntity.ok(customer);
    }
}
