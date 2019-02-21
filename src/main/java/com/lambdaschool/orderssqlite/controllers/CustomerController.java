package com.lambdaschool.orderssqlite.controllers;

import com.lambdaschool.orderssqlite.models.Customer;
import com.lambdaschool.orderssqlite.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path={"/customers"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    CustomerRepository custRepo;

    @GetMapping("")
    public List<Customer> allCustomers() {
        return custRepo.findAll();
    }
}
