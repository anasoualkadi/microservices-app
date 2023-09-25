package com.example.billingservice.repositories;

import com.example.billingservice.models.BillLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillLineRepository extends JpaRepository<BillLine,Long> {
}
