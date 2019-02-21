package com.lambdaschool.orderssqlite.repositories;

import com.lambdaschool.orderssqlite.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
