package com.ls.order.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private long ordnum;

    private long advanceamount;
    @Column(nullable = false)
    private long orderamount;
    private String orderdescription;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    private Customer customer;

    @ManyToMany()
    @JoinTable(name = "ORDERSPAYMENTS",
    joinColumns = @JoinColumn(name = "ordnum"),
    inverseJoinColumns = @JoinColumn(name = "paymentid"))
    private Set<Payment> payments = new HashSet<>();

    public Order(){}

    public Order(long advanceamount, long orderamount, String orderdescription) {
        this.advanceamount = advanceamount;
        this.orderamount = orderamount;
        this.orderdescription = orderdescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public long getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(long advanceamount) {
        this.advanceamount = advanceamount;
    }

    public long getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(long orderamount) {
        this.orderamount = orderamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
