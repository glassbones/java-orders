package com.ls.order.services;

import com.ls.order.models.Payment;
import com.ls.order.repos.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "paymentServ")
public class PaymentServImpli implements PaymentServ{

    @Autowired
    private PaymentRepo paymentRepos;

    @Transactional
    @Override
    public Payment save(Payment payment) {
        return paymentRepos.save(payment);
    }
}
