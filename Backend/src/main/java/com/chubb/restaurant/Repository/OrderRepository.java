package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
