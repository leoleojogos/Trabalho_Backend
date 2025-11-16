package com.example.tripshare.models.dtos.paymentSplit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PaymentSplitRequestDTO(

    @NotBlank(message = "O atributo 'title' não deve estar vazio")
    @Size(max = 100, message = "O atributo 'title' deve ter no máximo 100 caracteres")
    String title,

    @NotBlank(message = "O atributo 'description' não deve estar vazio")
    @Size(max = 100, message = "O atributo 'description' deve ter no máximo 100 caracteres")
    String description

) {}
