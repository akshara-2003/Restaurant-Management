package com.chubb.restaurant.Repository;

import com.chubb.restaurant.Model.MenuItem;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
    List<MenuItem> findByCategory(String category);
}
