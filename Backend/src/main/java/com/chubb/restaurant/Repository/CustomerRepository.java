package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByCustomerName(String customerName);

    Customer findByCustomerEmail(String customerEmail);

    Customer findByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);
}
