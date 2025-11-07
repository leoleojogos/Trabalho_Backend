package com.example.tripshare.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
    @NotBlank(message = "O campo 'name' não pode estar vazio")
    @Size(max = 100)
    String name,

    @NotBlank(message = "O campo 'email' não pode estar vazio")
    @Size(max = 150)
    @Email
    String email,

    @NotBlank(message = "O campo 'password' não pode estar vazio")
    @Size(max = 60)
    String password
) {}
