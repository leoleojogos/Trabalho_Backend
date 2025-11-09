package com.example.tripshare.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tripshare.mappers.UserMapper;
import com.example.tripshare.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    @SuppressWarnings("unused")
    private final PasswordEncoder passwordEncoder;
    
    @SuppressWarnings("unused")
    private final UserMapper userMapper;

    @SuppressWarnings("unused")
    private final UserRepository userRepository;

}
