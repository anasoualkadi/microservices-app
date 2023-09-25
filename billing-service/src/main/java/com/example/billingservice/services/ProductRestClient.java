package com.example.billingservice.services;

import com.example.billingservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {

    @GetMapping(path = "/products/{id}")
    public Product findProductById(@PathVariable Long id);

    @GetMapping("/products/getProducts")
    public List<Product> getProducts();

}
