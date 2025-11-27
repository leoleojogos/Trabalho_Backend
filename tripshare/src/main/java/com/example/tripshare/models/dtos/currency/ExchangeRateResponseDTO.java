package com.example.tripshare.models.dtos.currency;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ExchangeRateResponseDTO(
    @JsonProperty("result")
    String result,
    
    @JsonProperty("base_code")
    String baseCode,
    
    @JsonProperty("conversion_rates")
    Map<String, Double> conversionRates
) {}
