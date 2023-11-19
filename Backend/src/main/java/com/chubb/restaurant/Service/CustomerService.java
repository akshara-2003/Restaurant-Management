package com.chubb.restaurant.Service;

import com.chubb.restaurant.Model.CartItem;
import com.chubb.restaurant.Model.Customer;
import com.chubb.restaurant.Model.MenuItem;
import com.chubb.restaurant.Repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer addCustomer(Customer customer)
    {
       return repository.save(customer);
    }
    public List<Customer> findAllCustomers(){
        return repository.findAll();
    }

    public Customer findCustomerById(String customerId){
        return repository.findById(customerId).get();
    }

    public List<Customer> findCustomerByName(String customerName){
        return repository.findByCustomerName(customerName);
    }

    public Customer findCustomerByEmail(String customerEmail){
        return repository.findByCustomerEmail(customerEmail);
    }
    public Customer findCustomerByCustomerEmailAndCustomerPassword(String customerEmail,String customerPassword){
        return repository.findByCustomerEmailAndCustomerPassword(customerEmail,customerPassword);
    }
    public Customer updateCustomer(Customer newCustomer){
        Customer oldCustomer = repository.findById(newCustomer.getCustomerId()).get();
        oldCustomer.setCustomerEmail(newCustomer.getCustomerEmail());
        oldCustomer.setCustomerName(newCustomer.getCustomerName());
        oldCustomer.setCustomerPassword(newCustomer.getCustomerPassword());
        oldCustomer.setMobile(newCustomer.getMobile());
        oldCustomer.setCartItems(newCustomer.getCartItems());
        return repository.save(oldCustomer);
    }

    public String deleteCustomer(String customerId)
    {
        repository.deleteById(customerId);
        return customerId +"customer deleted";
    }
    public List<CartItem> getCartItemsByCustomerId(String customerId) {
        Customer customer = repository.findById(customerId).orElse(null);
        if (customer != null) {
            return customer.getCartItems();
        }
        return null;
    }

    public CartItem getCartItemByCustomerIdAndItemId(String customerId, String itemId) {
        Customer customer = repository.findById(customerId).orElse(null);
        if (customer != null) {
            return customer.getCartItems().stream().filter(cartItem -> cartItem.getItemId().equals(itemId)).findFirst().orElse(null);
        }
        return null;
    }

    public ResponseEntity<?> addCartItemToCustomer(String customerId, CartItem cartItem) {
        cartItem.setItemId(UUID.randomUUID().toString().split("-")[0]);
        Customer customer = repository.findById(customerId).orElse(null);
        if (customer != null) {
            List<CartItem> cartItems = customer.getCartItems();
            if(cartItems==null){
                cartItems=new ArrayList<>();
            }
            // Check if the item already exists in the cart
            boolean itemExists = false;
            for (CartItem existingCartItem : cartItems) {
                if (existingCartItem.getMenuItem().getItemId().equals(cartItem.getMenuItem().getItemId())) {
                    existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
                    itemExists = true;
                    break;
                }
            }
            // If the item doesn't exist in the cart, add it with the specified quantity
            if (!itemExists) {
                cartItems.add(cartItem);
            }
//            cartItems.add(cartItem);
            System.out.println(cartItem.getItemId());
            customer.setCartItems(cartItems);
            repository.save(customer);
            return ResponseEntity.ok(customer);
        }
        else{
            System.out.println("else case");
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public ResponseEntity<?>incrementCartQuantity( String customerId,String itemId){
        Customer customer = repository.findById(customerId).orElse(null);
        if (customer != null) {
            List<CartItem> cartItems = customer.getCartItems();
            for (CartItem cartItem : cartItems) {
                if (cartItem.getMenuItem().getItemId().equals(itemId)) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    repository.save(customer);
                    return ResponseEntity.ok(customer);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<?> decrementCartItemQuantity(String customerId, String itemId) {
        Customer customer = repository.findById(customerId).orElse(null);
        if (customer != null) {
            List<CartItem> cartItems = customer.getCartItems();
            for (CartItem cartItem : cartItems) {
                if (cartItem.getMenuItem().getItemId().equals(itemId)) {
                    if (cartItem.getQuantity() > 1) {
                        cartItem.setQuantity(cartItem.getQuantity() - 1);
                        repository.save(customer);
                        return ResponseEntity.ok(customer);
                    } else {
                        cartItems.remove(cartItem);
                        repository.save(customer);
                        return ResponseEntity.ok(customer);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public void updateCartItemOfCustomer(String customerId, CartItem cartItem) {
        Customer customer = repository.findById(customerId).orElse(null);
        if (customer != null) {
            List<CartItem> cartItems = customer.getCartItems();
            for (int i = 0; i < cartItems.size(); i++) {
                if (cartItems.get(i).getItemId().equals(cartItem.getItemId())) {
                    cartItems.set(i, cartItem);
                    break;
                }
            }
            customer.setCartItems(cartItems);
            repository.save(customer);
        }
    }

    public void deleteCartItemOfCustomer(String customerId, String itemId) {
        System.out.println(customerId+" "+ itemId);
        Customer customer = repository.findById(customerId).orElse(null);
        if (customer != null) {

            List<CartItem> cartItems = customer.getCartItems();
//            cartItems.removeIf(cartItem -> cartItem.getItemId().equals(itemId));
            int index=-1;
            System.out.println(cartItems.size());
            for(int i=0;i<cartItems.size();i++){
                System.out.println(cartItems.get(i).getItemId());
                if(cartItems.get(i).getItemId().equals(itemId))
                {
                    index=i;
                    break;
                }

            }
            cartItems.remove(index);
            customer.setCartItems(cartItems);
            repository.save(customer);
        }
    }
}
