package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.Manager;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ManagerRepository extends MongoRepository<Manager, String> {
    List<Manager> findByManagerEmail(String managerEmail);


    Manager findByManagerEmailAndManagerPassword(String managerEmail, String managerPassword);
}
