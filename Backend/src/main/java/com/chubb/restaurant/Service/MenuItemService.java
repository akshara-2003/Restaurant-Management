package com.chubb.restaurant.Service;

import com.chubb.restaurant.Model.Ingredient;
import com.chubb.restaurant.Model.MenuItem;
import com.chubb.restaurant.Repository.MenuItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository repository;

    public MenuItem addItem(MenuItem menuItem){
        return repository.save(menuItem);
    }
    public List<MenuItem> findAllItems(){
        return repository.findAll();
    }
    public MenuItem findItemById(String menuItemId){
        return repository.findById(menuItemId).get();
    }

    public MenuItem updateMenuItem(MenuItem menuItem) {
        MenuItem existingMenuItem =repository.findById(menuItem.getItemId()).get();
            existingMenuItem.setItemName(menuItem.getItemName());
            existingMenuItem.setCategory(menuItem.getCategory());
            existingMenuItem.setItemPrice(menuItem.getItemPrice());
            existingMenuItem.setIngredients(menuItem.getIngredients());
            existingMenuItem.setImageUrl(menuItem.getImageUrl());
            existingMenuItem.setAvailable(menuItem.isAvailable());
            return repository.save(existingMenuItem);
    }

    public void deleteMenuItem(String id) {
        repository.deleteById(id);
    }

    public List<Ingredient> getAllIngredients() {
        List<MenuItem> menuItems = repository.findAll();
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        for (MenuItem menuItem : menuItems) {
            ingredients.addAll(menuItem.getIngredients());
        }
        return ingredients;
    }

    public List<MenuItem> getMenuItemsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<MenuItem> getMenuItemsByIngredient(String ingredientName) {
        List<MenuItem> menuItems = repository.findAll();
        List<MenuItem> filteredMenuItems = new ArrayList<MenuItem>();
        for (MenuItem menuItem : menuItems) {
            for (Ingredient ingredient : menuItem.getIngredients()) {
                if (ingredient.getIngredientName().equalsIgnoreCase(ingredientName)) {
                    filteredMenuItems.add(menuItem);
                    break;
                }
            }
        }
        return filteredMenuItems;
    }
}
