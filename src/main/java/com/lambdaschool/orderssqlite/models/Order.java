package com.lambdaschool.orderssqlite.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long ordernum;

    private double ordamount;

    private double advanceamount;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    private Agent agent;

    private String orddescription;

    public Order()
    {
    }
}
