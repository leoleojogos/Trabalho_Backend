package com.example.tripshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.tripshare.models.dtos.user.UserRequestDTO;
import com.example.tripshare.models.dtos.user.UserResponseDTO;
import com.example.tripshare.models.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO request);
    
    UserResponseDTO toDTO(User user);

}
