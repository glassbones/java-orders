package com.ls.order;

//import com.github.javafaker.Faker;

import com.ls.order.models.Order;
import com.ls.order.models.Payment;
import com.ls.order.models.Customer;
import com.ls.order.models.Agent;
import com.ls.order.services.AgentServ;
import com.ls.order.services.CustomerServ;
import com.ls.order.services.OrderServ;
import com.ls.order.services.PaymentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner{

    @Autowired
    private AgentServ agentServ;

    @Autowired
    private PaymentServ paymentServ;

    @Autowired
    private OrderServ orderServ;

    @Autowired
    private CustomerServ customerServ;

    @Transactional
    @Override
    public void run(String[] args) throws Exception {
        Payment pay1 = new Payment("Cash");
        pay1 = paymentServ.save(pay1);
        Payment pay2 = new Payment("Credit Card");
        pay2 = paymentServ.save(pay2);
        Payment pay3 = new Payment("Mobile Pay");
        pay3 = paymentServ.save(pay3);

        // Agent String name, String address, String city, String state, String telephone
        // scope of r variables
        {
            //public Agent(String agentname, long commission, String country, String phone, String workingarea)
            Agent a1 = new Agent(
                    "smith",
                    123,
                    "usa",
                    "405-646-7863",
                    "the matrix");

            Customer c1 = new Customer(
                    "New York",
                    "USA",
                    "Neo",
                    "the one",
                    111,
                    222,
                    333,
                    "111-222-3333",
                    444,
                    "the matrix",
                    a1);

            Order o1 = new Order(
                    1000,
                    600,
                    "SOD",
                    c1);

            o1.getPayments().add(pay1);
            c1.getOrders().add(o1);
            a1.getCustomers().add(c1);


            agentServ.save(a1);
            customerServ.save(c1);
            orderServ.save(o1);


        }
    }
}
