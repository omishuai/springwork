package com.shuai.test.jpa;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

//this interface can be used directly to store data
// Customer and Long: entity and Id
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
}
