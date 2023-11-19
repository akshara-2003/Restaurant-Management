package com.chubb.restaurant.Controller;


import com.chubb.restaurant.Model.RegistrationRequest;
import com.chubb.restaurant.Model.UserCredentials;
import com.chubb.restaurant.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
   private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredentials credentials) {
       return authService.login(credentials.getEmail(),credentials.getPassword());
    }
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest registrationRequest){
        return authService.register(
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                registrationRequest.getName(),
                registrationRequest.getMobile()
        );
    }
}
