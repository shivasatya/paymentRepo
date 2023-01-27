package com.dailycodebuffer.paymentservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.paymentservice.entity.TransactionDetails;
import com.dailycodebuffer.paymentservice.model.PaymentRequest;
import com.dailycodebuffer.paymentservice.model.PaymentResponse;
import com.dailycodebuffer.paymentservice.model.PaymentWay;
import com.dailycodebuffer.paymentservice.repository.PaymentDao;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImp implements PaymentService {
	public static final String payment_Service = "PaymentService";

	@Autowired
	private PaymentDao paymentDao;

	public Long doPayment(PaymentRequest paymentRequest) {
		log.info(payment_Service, "{} Recording payment Details", paymentRequest);
		TransactionDetails transactionDetails = TransactionDetails.builder().orderId(paymentRequest.getOrderId())
				.paymentDate(Instant.now()).referenceNumber(paymentRequest.getReferenceNumber())
				.paymentMode(paymentRequest.getPaymentMode().name()).amount(paymentRequest.getAmount())
				.paymentStatus("Sucess").build();
		paymentDao.save(transactionDetails);
		log.info(payment_Service, "{} Transaction Completed", paymentRequest);
		return transactionDetails.getId();
	}

	@Override
	public PaymentResponse getPaymentDetailsByOrderId(Long orderId) {
		
	TransactionDetails transactionDetails =	paymentDao.findByOrderId(orderId);
	PaymentResponse paymentResponse = PaymentResponse.builder()
			.orderId(transactionDetails.getOrderId())
			.paymentMode(transactionDetails.getPaymentMode())
			.referenceNumber(transactionDetails.getReferenceNumber())
			.amount(transactionDetails.getAmount())
			.build();
		return paymentResponse;
	}

}
