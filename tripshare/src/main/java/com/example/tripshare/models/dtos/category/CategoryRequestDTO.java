package com.example.tripshare.models.dtos.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequestDTO(

    @NotBlank(message = "O atributo 'title' não deve estar vazio")
    @Size(max = 100, message = "O atributo 'title' deve ter no máximo 100 caracteres")
    String title,

    @Size(max = 100, message = "O atributo 'description' deve ter no máximo 100 caracteres")
    String description

) {}
