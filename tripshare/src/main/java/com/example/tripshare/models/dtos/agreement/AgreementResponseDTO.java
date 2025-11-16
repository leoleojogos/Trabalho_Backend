package com.example.tripshare.models.dtos.agreement;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgreementResponseDTO(

    UUID id,
    String title,
    String creatorName,
    String description,
    String currencyCode,
    Boolean isPaid,
    String paymentSplitName,
    String categoryName,
    LocalDateTime createdAt

) {}
