package com.example.tripshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.tripshare.models.dtos.group.GroupRequestDTO;
import com.example.tripshare.models.dtos.group.GroupResponseDTO;
import com.example.tripshare.models.entities.Group;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "isActive", constant = "true")
    
    @Mapping(target = "createdBy", ignore = true)
    Group toEntity(GroupRequestDTO dto);

    @Mapping(target = "creatorName", source = "createdBy.name")
    GroupResponseDTO toDTO(Group entity);
    
}
