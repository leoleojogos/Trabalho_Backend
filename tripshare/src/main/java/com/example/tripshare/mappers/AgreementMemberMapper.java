package com.example.tripshare.mappers;

import org.mapstruct.*;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberRequestDTO;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberResponseDTO;
import com.example.tripshare.models.entities.AgreementMember;
import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.models.entities.Agreement;

@Mapper(componentModel = "spring")
public interface AgreementMemberMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "member", ignore = true)
    @Mapping(target = "agreement", ignore = true)
    AgreementMember toEntity(AgreementMemberRequestDTO request);

    @Mapping(target = "memberName", ignore = true)
    @Mapping(target = "groupName", ignore = true)
    AgreementMemberResponseDTO toResponseDTO(AgreementMember entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(
            @MappingTarget AgreementMember entity,
            AgreementMemberRequestDTO dto,
            GroupMember member,
            Agreement agreement
    );
}
