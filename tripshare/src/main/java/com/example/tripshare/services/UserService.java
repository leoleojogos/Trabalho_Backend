package com.example.tripshare.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripshare.mappers.UserMapper;
import com.example.tripshare.repositories.UserRepository;
import com.example.tripshare.models.entities.User;
import com.example.tripshare.models.dtos.user.UserRequestDTO;
import com.example.tripshare.models.dtos.user.UserResponseDTO;

import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserResponseDTO create(UserRequestDTO request) {
        User entity = userMapper.toEntity(request);
        entity.setPassword(passwordEncoder.encode(request.password()));
        User saved = userRepository.save(entity);
        return userMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public UserResponseDTO getById(UUID id) {
        User entity = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
        return userMapper.toDTO(entity);
    }

    @SuppressWarnings("null")
    public Page<UserResponseDTO> getAll(Pageable pageable) {
        return userRepository.findAll(pageable)
            .map(userMapper::toDTO);
    }

    @SuppressWarnings("null")
    public UserResponseDTO update(UUID id, UserRequestDTO request) {
        User entity = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
        userMapper.update(entity, request);
        User saved = userRepository.save(entity);
        return userMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public void delete(UUID id) {
        User entity = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
        userRepository.delete(entity);
    }
}
