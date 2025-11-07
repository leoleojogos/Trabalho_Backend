package com.example.tripshare.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private PasswordEncoder passwordEncoder;

    public UserService(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

}
