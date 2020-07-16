package com.ls.order.services;


import com.ls.order.models.Customer;
import com.ls.order.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;



@Transactional
@Service(value = "customerServ")
public class CustomerServImpli implements CustomerServ {

    @Autowired
    private CustomerRepo customerRepos;

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerRepos.save(customer);
    }
}