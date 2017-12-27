package com.samson.onlineshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int customerId;

    @Column
    private String name;

    @Column
    private String address;

    @Column(name = "no_of_orders_made")
    private int noOfOrdersMade;

    public Customer(){

    }

    public Customer(String name, String address, int noOfOrdersMade) {
        this.name = name;
        this.address = address;
        this.noOfOrdersMade = noOfOrdersMade;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(int noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }
}
