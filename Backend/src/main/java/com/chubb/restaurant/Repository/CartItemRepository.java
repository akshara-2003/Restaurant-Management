package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.CartItem;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartItemRepository extends MongoRepository<CartItem, String> {
}
