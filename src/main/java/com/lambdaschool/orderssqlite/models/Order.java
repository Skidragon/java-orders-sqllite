package com.lambdaschool.orderssqlite.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ordnum")
    private long id;

    private double ordamount;

    private double advanceamount;

    private String orddescription;

    @ManyToOne
    @JoinColumn(name="custcode")
    @JsonIgnore
    Customer customer;

    @ManyToOne
    @JoinColumn(name="agentcode")
    @JsonIgnore
    Agent agent;



    public Order() {
    }
}
