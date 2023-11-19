package com.chubb.restaurant.Controller;

import com.chubb.restaurant.Model.AddItem;
import com.chubb.restaurant.Model.MenuItem;
import com.chubb.restaurant.Model.RegistrationRequest;
import com.chubb.restaurant.Service.AddItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/item")
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private AddItemService service;

    @PostMapping("/addItem")
    public String addItem(@RequestBody AddItem addItem) {
        return service.addItem(
                addItem.getItemName(),
                addItem.getCategory(),
                addItem.getItemPrice(),
                addItem.getImageUrl()
        );
    }
    @PutMapping("/editItem/{itemId}")
    public ResponseEntity<?> updateItem(@PathVariable String itemId, @RequestBody MenuItem newItem){
        return service.editItem(itemId,newItem);
    }
    @DeleteMapping("/deleteItem/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable String itemId){
        return service.deleteMenuItem(itemId);
    }
}
