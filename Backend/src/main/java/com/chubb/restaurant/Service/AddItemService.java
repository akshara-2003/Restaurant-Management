package com.chubb.restaurant.Service;

import com.chubb.restaurant.Model.AddItem;
import com.chubb.restaurant.Model.Customer;
import com.chubb.restaurant.Model.MenuItem;
import com.chubb.restaurant.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddItemService {
    @Autowired
    private MenuItemRepository repository;

    public String addItem(String itemName,String category,Float price,String imageLink){
        MenuItem newItem = new MenuItem();

        newItem.setItemName(itemName);
       newItem.setCategory(category);
       newItem.setItemPrice(price);
       newItem.setImageUrl(imageLink);
        repository.save(newItem);
        return "done";
    }
    public ResponseEntity<?> editItem(String itemId, MenuItem newItem){
        MenuItem oldItem = repository.findById(itemId).orElse(null);;
        if(oldItem!=null) {
            oldItem.setItemName(newItem.getItemName());
            oldItem.setCategory(newItem.getCategory());
            oldItem.setItemPrice(newItem.getItemPrice());
            oldItem.setImageUrl(newItem.getImageUrl());
            repository.save(oldItem);
            return ResponseEntity.ok(oldItem);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<?> deleteMenuItem(String menuItemId) {
        MenuItem menuItem = repository.findById(menuItemId).orElse(null);
        if (menuItem != null) {
            repository.delete(menuItem);
            return ResponseEntity.ok("Menu item deleted successfully.");
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
