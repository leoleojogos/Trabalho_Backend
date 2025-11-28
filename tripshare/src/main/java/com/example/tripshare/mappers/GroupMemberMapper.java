package com.example.tripshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.tripshare.models.dtos.groupMember.GroupMemberRequestDTO;
import com.example.tripshare.models.dtos.groupMember.GroupMemberResponseDTO;
import com.example.tripshare.models.entities.GroupMember;

@Mapper(componentModel = "spring")
public interface GroupMemberMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "groupId", ignore = true)
    @Mapping(target = "isAdmin", ignore = true)
    @Mapping(target = "inGroup", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    GroupMember toEntity(GroupMemberRequestDTO request);

    @Mapping(target = "userName", source = "userId.name")
    @Mapping(target = "groupName", source = "groupId.name")
    GroupMemberResponseDTO toDTO(GroupMember entity);

}
