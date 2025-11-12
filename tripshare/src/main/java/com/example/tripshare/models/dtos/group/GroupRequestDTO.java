package com.example.tripshare.models.dtos.group;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GroupRequestDTO(

    @NotBlank(message = "O atributo 'name' não pode estar vazio")
    String name,

    @Size(max = 200)
    String description,

    @NotBlank(message = "O valor do atributo 'currency_code' não pode estar vazio")
    String currencyCode
    
) {}
