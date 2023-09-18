package com.example.inventoryservice.controllers;

import com.example.inventoryservice.models.Product;
import com.example.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(null);

        return ResponseEntity.ok(product);
    }
}
