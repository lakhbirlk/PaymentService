package org.example.payment.service;

import org.example.payment.model.Payment;
import lombok.extern.slf4j.Slf4j;  // Lombok for logging
import org.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(String bookingId, String userId, double amount) {
        log.info("Processing payment for bookingId: {}, userId: {}, amount: {}", bookingId, userId, amount);

        // Simulate payment processing logic (e.g., if the amount is greater than 0, payment is successful)
        if (amount <= 0) {
            log.warn("Invalid payment amount for bookingId: {}, amount must be greater than 0", bookingId);
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }

        String paymentStatus = "success";  // Assume payment is successful if amount is valid

        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setUserId(userId);
        payment.setPaymentStatus(paymentStatus);
        payment.setDateOfPayment(new Date());
        payment.setAmount(amount);

        Payment savedPayment = paymentRepository.save(payment);
        log.info("Payment processed successfully with paymentStatus: {}", paymentStatus);

        return savedPayment;
    }

    // Optional: You can add method to fetch payment by ID if needed
    public Payment getPayment(Long id) {
        log.info("Fetching payment details for payment ID: {}", id);
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}
