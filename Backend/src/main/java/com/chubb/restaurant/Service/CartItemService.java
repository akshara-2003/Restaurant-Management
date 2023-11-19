package com.chubb.restaurant.Service;

import com.chubb.restaurant.Model.CartItem;
import com.chubb.restaurant.Repository.CartItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository repository;

    public CartItem addCartItem(CartItem cartItem) {
        return repository.save(cartItem);
    }
    public List<CartItem> findAllCartItems() {
        return repository.findAll();
    }

    public CartItem findCartItemById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void updateCartItem(CartItem cartItem) {
        CartItem existingCartItem = findCartItemById(cartItem.getItemId());
        if (existingCartItem != null) {
            existingCartItem.setMenuItem(cartItem.getMenuItem());
            existingCartItem.setQuantity(cartItem.getQuantity());
            existingCartItem.setInstructions(cartItem.getInstructions());
            repository.save(existingCartItem);
        }
    }
    public void deleteCartItem(String id) {
        repository.deleteById(id);
    }
}
