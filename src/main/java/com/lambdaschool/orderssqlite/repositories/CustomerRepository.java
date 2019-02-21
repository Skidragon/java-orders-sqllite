package com.lambdaschool.orderssqlite.repositories;

import com.lambdaschool.orderssqlite.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value ="SELECT * FROM customers c WHERE c.custcode = :custcode", nativeQuery = true)
    Customer findCustomerByCode(@Param("custcode") long custcode);
}
