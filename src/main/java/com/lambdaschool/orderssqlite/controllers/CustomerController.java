package com.lambdaschool.orderssqlite.controllers;

import com.lambdaschool.orderssqlite.models.Customer;
import com.lambdaschool.orderssqlite.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("order")
    public List<Object[]> allCustomersWithOrders() {
        return custRepo.findAllCustomersWithOrders();
    }
    @PutMapping("custcode/{custcode}")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable long custcode) throws URISyntaxException {
        Optional<Customer> foundCustomer = custRepo.findById(custcode);
        if(foundCustomer.isPresent()) {
            updatedCustomer.setCustcode(custcode);
            custRepo.save(updatedCustomer);
            return updatedCustomer;
        }
        return null;
    }

    @DeleteMapping("custcode/{custcode}")
    public Customer deleteCustomer(@PathVariable long custcode) {
        Customer foundCustomer = custRepo.findCustomerByCode(custcode);
        if (foundCustomer != null) {
            custRepo.deleteById(custcode);
            return foundCustomer;
        }
        return null;
    }
}
