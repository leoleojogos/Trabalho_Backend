package com.example.tripshare.models.dtos.currency;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrencyConversionResponseDTO(
    @JsonProperty("from")
    String from,
    
    @JsonProperty("to")
    String to,
    
    @JsonProperty("amount")
    BigDecimal amount,
    
    @JsonProperty("converted_amount")
    BigDecimal convertedAmount,
    
    @JsonProperty("exchange_rate")
    BigDecimal exchangeRate
) {}
