package com.example.tripshare.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.tripshare.models.dtos.paymentSplit.PaymentSplitRequestDTO;
import com.example.tripshare.models.dtos.paymentSplit.PaymentSplitResponseDTO;
import com.example.tripshare.models.entities.PaymentSplit;

@Mapper(componentModel = "spring")
public interface PaymentSplitMapper {
    
    @Mapping(target = "id", ignore = true)
    PaymentSplit toEntity(PaymentSplitRequestDTO request);

    PaymentSplitResponseDTO toDTO(PaymentSplit paymentSplit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget PaymentSplit paymentSplit, PaymentSplitRequestDTO request);

}
