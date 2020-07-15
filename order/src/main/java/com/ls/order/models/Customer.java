package com.ls.order.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;
    //private long agentcode;

    private String custcity;
    private String custcountry;
    private String custname;
    private String grade;
    private long openingamt;
    private long outstandingamt;
    private long paymentamt;
    private String phone;
    private long receiveamt;
    private String workingarea;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    private Agent agent;

    @OneToMany(mappedBy = "custcode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> Orders = new ArrayList<>();

    public Customer(){}

    public Customer(String custcity, String custcountry, String custname, String grade, long openingamt, long outstandingamt, long paymentamt, String phone, long receiveamt, String workingarea) {
        this.custcity = custcity;
        this.custcountry = custcountry;
        this.custname = custname;
        this.grade = grade;
        this.openingamt = openingamt;
        this.outstandingamt = outstandingamt;
        this.paymentamt = paymentamt;
        this.phone = phone;
        this.receiveamt = receiveamt;
        this.workingarea = workingarea;
    }

    public long getCustcode() {
        return custcode;
    }

    public void setCustcode(long custcode) {
        this.custcode = custcode;
    }
/*
    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }
*/
    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public long getOpeningamt() {
        return openingamt;
    }

    public void setOpeningamt(long openingamt) {
        this.openingamt = openingamt;
    }

    public long getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(long outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public long getPaymentamt() {
        return paymentamt;
    }

    public void setPaymentamt(long paymentamt) {
        this.paymentamt = paymentamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getReceiveamt() {
        return receiveamt;
    }

    public void setReceiveamt(long receiveamt) {
        this.receiveamt = receiveamt;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
