package com.example.tripshare.models.dtos.Agreement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AgreementRequestDTO(

    @NotBlank(message = "O valor do atributo 'title' não pode estar vazio")
    @Size(max = 200, message = "O atributo 'title' de 'Agreement' deve ter no máximo 200 caracteres")
    String title,

    @NotBlank(message = "O valor do atributo 'description' não pode estar vazio")
    @Size(max = 200, message = "O valor do atributo 'description' é de no máximo 200 caracteres")
    String description,

    @NotBlank(message = "O valor do atributo 'currency_code' não pode estar vazio")
    @Size(min = 3, max = 3, message = "O atributo 'currency_code' deve ter 3 caracteres")
    String currencyCode,

    // Os valores string abaixo precisarão ser validados no banco
    @NotNull(message = "O valor de 'payment_split' não pode estar vazio")
    String paymentSplit,

    @NotNull(message = "O valor de 'category' não pode estar vazio")
    String category

){}
