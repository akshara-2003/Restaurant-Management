package com.chubb.restaurant.Controller;

import com.chubb.restaurant.Model.Ingredient;
import com.chubb.restaurant.Model.MenuItem;
import com.chubb.restaurant.Service.MenuItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/menu")

public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;
    @PostMapping
    public MenuItem createItem(@RequestBody MenuItem menuItem){
        return menuItemService.addItem(menuItem);
    }
    @GetMapping("")
    public List<MenuItem> getAllItems(){
        return menuItemService.findAllItems();
    }
    @GetMapping("/{menuItemId}")
    public MenuItem findItemById(@PathVariable String menuItemId)
    {
        return menuItemService.findItemById(menuItemId);
    }
    @GetMapping("category/{category}")
    public List<MenuItem> findItemByCategory(@PathVariable String category){
        return menuItemService.getMenuItemsByCategory(category);
    }
    @GetMapping("ingredient/{ingredient}")
    public List<MenuItem> findItemByIngredient(@PathVariable String ingredient){
        return menuItemService.getMenuItemsByIngredient(ingredient);
    }
    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients(){
        return menuItemService.getAllIngredients();
    }
    @PutMapping
    public MenuItem updateItem(@RequestBody MenuItem menuItem){
        return menuItemService.updateMenuItem(menuItem);
    }
    @DeleteMapping("/{menuItemId}")
    public void deleteItem(@PathVariable String menuItemId){
       menuItemService.deleteMenuItem(menuItemId);
    }

}
