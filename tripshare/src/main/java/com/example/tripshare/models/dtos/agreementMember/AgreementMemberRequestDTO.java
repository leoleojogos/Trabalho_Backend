package com.example.tripshare.models.dtos.agreementMember;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record AgreementMemberRequestDTO(

    @NotNull(message = "O valor do campo 'member_id' não pode estar vazio")
    UUID memberId,

    @NotNull(message = "O valor do campo 'agreement_id' não pode estar vazio")
    UUID agreementId,

    @NotNull(message = "O valor do atributo 'is_creditor' não pode estar vazio")
    Boolean isCreditor

) {}
