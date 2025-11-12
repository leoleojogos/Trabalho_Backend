package com.example.tripshare.models.dtos.groupMember;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record GroupMemberRequestDTO(

    @NotNull(message = "O valor do campo 'user_id' não pode estar vazio")
    UUID userId,

    @NotNull(message = "O valor de 'group_id' não pode estar vazio")
    UUID groupId

) {}
