package com.example.tripshare.models.dtos.groupMember;

import java.time.LocalDateTime;
import java.util.UUID;

public record GroupMemberResponseDTO(

    UUID id,
    Boolean isAdmin,
    LocalDateTime joinedAt

) {}
