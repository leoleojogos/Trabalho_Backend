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

    @Mapping(target = "memberName", expression = "java(agreementMember.getMemberId() != null ? agreementMember.getMemberId().getUserId().getName() : null)")
    @Mapping(target = "groupName", expression = "java(agreementMember.getAgreementId() != null ? agreementMember.getAgreementId().getTitle() : null)")
    AgreementMemberResponseDTO toDTO(AgreementMember agreementMember);

}

