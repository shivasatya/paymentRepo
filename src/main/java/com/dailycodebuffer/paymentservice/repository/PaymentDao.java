package com.dailycodebuffer.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.paymentservice.entity.TransactionDetails;

@Repository
public interface PaymentDao extends JpaRepository<TransactionDetails, Long> {

	TransactionDetails findByOrderId(Long orderId);

}
