package com.example.tripshare.models.dtos.paymentSplit;

import java.util.UUID;

public record PaymentSplitResponseDTO(

    UUID id,
    String title,
    String description

) {}
