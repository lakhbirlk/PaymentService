package org.example.payment.controller;

import org.example.payment.model.Payment;

import org.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public Payment processPayment(@RequestParam("bookingId") String bookingId,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("amount") double amount) {
        return paymentService.processPayment(bookingId, userId, amount);
    }

    // Optional: Get payment details by ID
    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }
}
