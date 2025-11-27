package com.example.tripshare.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.tripshare.models.dtos.groupMember.GroupMemberRequestDTO;
import com.example.tripshare.models.dtos.groupMember.GroupMemberResponseDTO;
import com.example.tripshare.models.entities.GroupMember;

@Mapper(componentModel = "spring")
public interface GroupMemberMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "groupId", ignore = true)
    @Mapping(target = "inGroup", ignore = true)
    @Mapping(target = "isAdmin", ignore = true)
    @Mapping(target = "leftAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    GroupMember toEntity(GroupMemberRequestDTO request);

    @Mapping(source = "createdAt", target = "joinedAt")
    @Mapping(target = "userName", ignore = true)
    @Mapping(target = "groupName", ignore = true)
    GroupMemberResponseDTO toDTO(GroupMember groupMember);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "groupId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget GroupMember groupMember, GroupMemberRequestDTO request);

}
