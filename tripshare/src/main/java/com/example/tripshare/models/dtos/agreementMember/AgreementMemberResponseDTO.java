package com.example.tripshare.models.dtos.agreementMember;

import java.math.BigDecimal;
import java.util.UUID;

public record AgreementMemberResponseDTO(

    UUID id,
    String memberName,
    String groupName,
    Boolean isCreditor,
    BigDecimal amount

) {}
