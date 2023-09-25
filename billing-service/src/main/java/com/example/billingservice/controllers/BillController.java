package com.example.billingservice.controllers;

import com.example.billingservice.models.Bill;
import com.example.billingservice.repositories.BillRepository;
import com.example.billingservice.services.CustomerRestClient;
import com.example.billingservice.services.ProductRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills/")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerRestClient customerRestClient;

    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(null);
        if (bill != null) {
            bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
            bill.getBillLines().forEach(bl -> bl.setProduct(productRestClient.findProductById(bl.getProductId())));
        }
        return ResponseEntity.ok(bill);
    }
}
