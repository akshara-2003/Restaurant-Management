package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepository extends MongoRepository<OrderItem,String> {
}
