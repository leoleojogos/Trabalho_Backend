package com.example.tripshare.models.dtos.group;

import java.util.UUID;

public record GroupResponseDTO(

    UUID id,
    String name,
    String description,
    String currencyCode,
    Boolean isActive,
    UUID createdBy

) {}
