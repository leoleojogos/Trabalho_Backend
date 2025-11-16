package com.example.tripshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.tripshare.models.dtos.agreementMember.AgreementMemberRequestDTO;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberResponseDTO;
import com.example.tripshare.models.entities.AgreementMember;

@Mapper(componentModel = "spring")
public interface AgreementMemberMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "agreementId", ignore = true)
    @Mapping(target = "memberId", ignore = true)
    AgreementMember toEntity(AgreementMemberRequestDTO request);

    @Mapping(target = "memberName", ignore = true)
    @Mapping(target = "groupName", ignore = true)
    AgreementMemberResponseDTO toDTO(AgreementMember agreementMember);

}
