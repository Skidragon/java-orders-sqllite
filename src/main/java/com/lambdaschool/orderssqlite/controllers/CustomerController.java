package com.lambdaschool.orderssqlite.controllers;

import com.lambdaschool.orderssqlite.models.Customer;
import com.lambdaschool.orderssqlite.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
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

    @GetMapping("custcode/{custcode}")
    public Customer findCustomerByCode(@PathVariable long custcode) {
        return custRepo.findCustomerByCode(custcode);
    }

    @PostMapping("")
    public Customer addNewCustomer(@RequestBody Customer newCustomer) throws URISyntaxException {
        return custRepo.save(newCustomer);
    }

}
