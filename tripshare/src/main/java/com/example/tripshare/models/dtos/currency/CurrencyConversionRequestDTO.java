package com.example.tripshare.models.dtos.currency;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CurrencyConversionRequestDTO(
    @NotBlank(message = "Moeda de origem não pode ser vazia")
    String from,
    
    @NotBlank(message = "Moeda de destino não pode ser vazia")
    String to,
    
    @NotNull(message = "Valor não pode ser null")
    BigDecimal amount
) {}
