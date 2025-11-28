package com.example.tripshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;
import com.example.tripshare.models.entities.Agreement;

@Mapper(componentModel = "spring")
public interface AgreementMapper{
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "exchangeRate", ignore = true)
    @Mapping(target = "isPaid", ignore = true)
    @Mapping(target = "paymentSplit", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Agreement toEntity(AgreementRequestDTO request);

    @Mapping(target = "creatorName", source = "createdBy.userId.name")
    @Mapping(target = "paymentSplitName", source = "paymentSplit.title")
    @Mapping(target = "categoryName", source = "category.title")
    AgreementResponseDTO toDTO(Agreement agreement);

}