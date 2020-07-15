package com.ls.order.services;

import com.ls.order.models.Order;
import com.ls.order.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "orderServ")
public class OrderServImpli implements OrderServ {

    @Autowired
    private OrderRepo orderRepos;

    @Transactional
    @Override
    public Order save(Order order) {
        return orderRepos.save(order);
    }
}
