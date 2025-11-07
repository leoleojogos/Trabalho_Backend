package com.example.tripshare.models.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
    UUID id,
    String name,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
