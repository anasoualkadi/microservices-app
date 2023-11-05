package com.example.customerservice.controllers;

import com.example.customerservice.models.Customer;
import com.example.customerservice.repostitories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createCustomers")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
}
