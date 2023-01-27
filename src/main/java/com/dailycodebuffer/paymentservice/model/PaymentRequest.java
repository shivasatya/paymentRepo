package com.dailycodebuffer.paymentservice.model;

import java.time.Instant;

import com.dailycodebuffer.paymentservice.entity.TransactionDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
	
	private Long orderId;
	private PaymentWay paymentMode;
	private String referenceNumber;
	private Long amount;
}
