package com.dailycodebuffer.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {
	
	private Long orderId;
	private String paymentMode;
	private String referenceNumber;
	private Long amount;
}
