package com.chubb.restaurant.Service;

import com.chubb.restaurant.Model.Customer;
import com.chubb.restaurant.Model.Manager;
import com.chubb.restaurant.Model.Staff;
import com.chubb.restaurant.Model.UserCredentials;
import com.chubb.restaurant.Repository.CustomerRepository;
import com.chubb.restaurant.Repository.ManagerRepository;
import com.chubb.restaurant.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class AuthService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<?> login(String email, String password) {
        Manager manager = managerRepository.findByManagerEmailAndManagerPassword(email,password);
        if(manager!=null)
            return ResponseEntity.ok(manager);
        Staff staff=staffRepository.findByStaffEmailAndStaffPassword(email,password);
        if(staff!=null)
            return ResponseEntity.ok(staff);
        Customer customer = customerRepository.findByCustomerEmailAndCustomerPassword(email,password);
        if (customer!=null)
            return ResponseEntity.ok(customer);
        return null;
    }
    public String register(String email,String password,String name,String mobile){
        Customer existingCustomer = customerRepository.findByCustomerEmail(email);

        if (existingCustomer != null) {
            // User already exists, return an error message
            return "User already exists with this email address";
        }
        Customer newCustomer = new Customer();

        newCustomer.setCustomerEmail(email);
        newCustomer.setCustomerPassword(password);
        newCustomer.setCustomerName(name);
        newCustomer.setMobile(mobile);
        customerRepository.save(newCustomer);
        return "done";
    }
}
