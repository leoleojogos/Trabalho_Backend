package com.example.tripshare.models.dtos.category;

import java.util.UUID;

public record CategoryResponseDTO(

    UUID id,
    String title,
    String description

) {}
