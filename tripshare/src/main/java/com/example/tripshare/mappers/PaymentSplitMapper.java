package com.example.tripshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.tripshare.models.dtos.paymentSplit.PaymentSplitRequestDTO;
import com.example.tripshare.models.dtos.paymentSplit.PaymentSplitResponseDTO;
import com.example.tripshare.models.entities.PaymentSplit;

@Mapper(componentModel = "spring")
public interface PaymentSplitMapper {
    
    @Mapping(target = "id", ignore = true)
    PaymentSplit toEntity(PaymentSplitRequestDTO request);

    PaymentSplitResponseDTO toDTO(PaymentSplit paymentSplit);

}
