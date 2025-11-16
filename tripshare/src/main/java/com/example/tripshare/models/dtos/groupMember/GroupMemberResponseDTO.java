package com.example.tripshare.models.dtos.groupMember;

import java.time.LocalDateTime;
import java.util.UUID;

public record GroupMemberResponseDTO(

    UUID id,
    String userName,
    String groupName,
    Boolean isAdmin,
    LocalDateTime joinedAt    

) {}
