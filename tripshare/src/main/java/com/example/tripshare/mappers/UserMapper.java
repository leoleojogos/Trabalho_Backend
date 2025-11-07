package com.example.tripshare.mappers;

import org.mapstruct.Mapper;

import com.example.tripshare.models.dtos.UserRequestDTO;
import com.example.tripshare.models.dtos.UserResponseDTO;
import com.example.tripshare.models.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    User toEntity(UserRequestDTO request);
    UserResponseDTO toDTO(User user);

}
