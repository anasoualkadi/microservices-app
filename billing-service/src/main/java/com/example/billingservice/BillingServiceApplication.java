package com.example.billingservice;

import com.example.billingservice.entities.Customer;
import com.example.billingservice.entities.Product;
import com.example.billingservice.models.Bill;
import com.example.billingservice.models.BillLine;
import com.example.billingservice.repositories.BillLineRepository;
import com.example.billingservice.repositories.BillRepository;
import com.example.billingservice.services.CustomerRestClient;
import com.example.billingservice.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BillRepository billRepository,
							BillLineRepository billLineRepository,
							CustomerRestClient customerRestClient,
							ProductRestClient productRestClient){
		return args -> {
			List<Product> products=productRestClient.getProducts();
			Long customerId=1L;
			Customer customer=customerRestClient.findCustomerById(customerId);
			if(customer==null) throw new RuntimeException("Customer not found");
			Bill bill=new Bill();
			bill.setBillDate(new Date());
			bill.setCustomerId(customerId);
			Bill savedBill = billRepository.save(bill);
			products.forEach(product -> {
				BillLine billLine=new BillLine();
				billLine.setBill(savedBill);
				billLine.setProductId(product.getId());
				billLine.setQuantity(1+new Random().nextInt(10));
				billLine.setPrice(product.getPrice());
				billLine.setDiscount(Math.random());
				billLineRepository.save(billLine);
			});

		};
	}
}
