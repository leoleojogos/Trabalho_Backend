package com.example.tripshare.models.dtos.group;

import java.time.LocalDateTime;
import java.util.UUID;

public record GroupResponseDTO(

    UUID id,
    String name,
    String description,
    String currencyCode,
    Boolean isActive,
    String creatorName,
    LocalDateTime createdAt

) {}
