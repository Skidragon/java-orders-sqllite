package com.lambdaschool.orderssqlite.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agentcode", nullable = false)
    private long id;

    private String workingarea;

    private double commission;

    private String phone;

    private String country;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "agent")
    private Set<Customer> customers;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "agent")
    private Set<Order> orders;

    public Agent() {
    }
}
