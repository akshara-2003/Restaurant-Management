package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment,String> {
}
