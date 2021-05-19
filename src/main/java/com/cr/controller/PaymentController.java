package com.cr.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.cr.model.Payment;
import com.cr.services.repository.jdbc.PaymentRepository;

public class PaymentController {

    PaymentRepository _repository;

    public PaymentController() throws IOException {
        _repository = new PaymentRepository();
    }

    public void create(Payment model) {

    }

    public List<Payment> getAll(Predicate<Payment> filter) {
        return _repository.getAll(filter);
    }

    public Payment find(Predicate<Payment> filter) {

        return _repository.find(filter);
    }

}
