package com.example.tripshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.tripshare.models.dtos.group.GroupRequestDTO;
import com.example.tripshare.models.dtos.group.GroupResponseDTO;
import com.example.tripshare.models.entities.Group;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    Group toEntity(GroupRequestDTO request);

    @Mapping(target = "creatorName", ignore = true)
    GroupResponseDTO toDTO(Group group);
    
}
