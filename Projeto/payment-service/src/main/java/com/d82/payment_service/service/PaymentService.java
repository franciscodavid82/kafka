package com.d82.payment_service.service;

import com.d82.payment_service.model.Payment;

public interface PaymentService {
    void sendPayment (Payment payment);
}
