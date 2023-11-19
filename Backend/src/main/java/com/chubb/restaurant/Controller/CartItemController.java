package com.chubb.restaurant.Controller;

import com.chubb.restaurant.Model.CartItem;
import com.chubb.restaurant.Service.CartItemService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItems")
public class CartItemController {
    private CartItemService cartItemService;
    @PostMapping
    public CartItem addItem(@RequestBody CartItem cartItem){
        return cartItemService.addCartItem(cartItem);
    }
    @GetMapping("")
    public List<CartItem> findAllCartItems()
    {
        return cartItemService.findAllCartItems();
    }
    @GetMapping("/{cartItemId}")
    public CartItem findCartItemById(@PathVariable String cartItemId){
        return cartItemService.findCartItemById(cartItemId);
    }
    @PutMapping
    public void updateCartItem(CartItem cartItem){
         cartItemService.updateCartItem(cartItem);
    }
    @DeleteMapping("/{cartItemId}")
    public void deleteCartItem(@PathVariable String cartItemId){
        cartItemService.deleteCartItem(cartItemId);
    }
}
