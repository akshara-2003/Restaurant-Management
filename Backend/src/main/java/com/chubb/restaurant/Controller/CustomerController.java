package com.chubb.restaurant.Controller;

import com.chubb.restaurant.Model.CartItem;
import com.chubb.restaurant.Model.Customer;
import com.chubb.restaurant.Model.MenuItem;
import com.chubb.restaurant.Repository.CustomerRepository;
import com.chubb.restaurant.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @GetMapping("")
    public List<Customer> getCustomers(){
        return customerService.findAllCustomers();
    }
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId){
        return customerService.findCustomerById(customerId);
    }
    @GetMapping("/email/{customerEmail}")
    public Customer getCustomerByEmail(@PathVariable String customerEmail){
        return customerService.findCustomerByEmail(customerEmail);
    }
    @GetMapping("/email/{customerEmail}/password/{customerPassword}")
    public Customer getCustomerByEmailAndPassword(@PathVariable String customerEmail,@PathVariable String customerPassword){
        return customerService.findCustomerByCustomerEmailAndCustomerPassword(customerEmail,customerPassword);
    }
    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable String customerId){
        return customerService.deleteCustomer(customerId);
    }
    @PostMapping("/{customerId}/cartItems")
    public ResponseEntity<?> addCartItemToCustomer(@PathVariable String customerId,@RequestBody CartItem cartItem){
        return customerService.addCartItemToCustomer(customerId,cartItem);
    }
    @GetMapping("/{customerId}/cartItems")
    public List<CartItem> getCartItemsByCustomerId(@PathVariable String customerId){
        return customerService.getCartItemsByCustomerId(customerId);
    }
    @GetMapping("/{customerId}/cartItems/{itemId}")
    public CartItem getCartItemsByCustomerIdAndItemId(@PathVariable String customerId,@PathVariable String itemId){
        return customerService.getCartItemByCustomerIdAndItemId(customerId,itemId);
    }
    @PutMapping("/{customerId}/cartItems/{itemId}")
    public void updateCartItemsOfCustomer(@PathVariable String customerId, String itemId,@PathVariable CartItem cartItem){
        cartItem.setItemId(itemId);
        customerService.updateCartItemOfCustomer(customerId, cartItem);
    }
    @DeleteMapping("/{customerId}/cartItems/{itemId}")
    public void deleteCartItemOfCustomer(@PathVariable String customerId,@PathVariable String itemId){
        customerService.deleteCartItemOfCustomer(customerId,itemId);
    }
    @PostMapping("/{customerId}/cartItems/increment/{itemId}")
    public ResponseEntity<?>incrementCartQuantity(@PathVariable String customerId,@PathVariable String itemId){
       return customerService.incrementCartQuantity(customerId,itemId);
    }
    @PostMapping("/{customerId}/cartItems/decrement/{itemId}")
    public ResponseEntity<?>decrementCartQuantity(@PathVariable String customerId,@PathVariable String itemId){
        return customerService.decrementCartItemQuantity(customerId,itemId);
    }
}
