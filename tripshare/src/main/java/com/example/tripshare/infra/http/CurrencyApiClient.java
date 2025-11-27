package com.example.tripshare.infra.http;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.example.tripshare.models.dtos.currency.ExchangeRateResponseDTO;
import java.math.BigDecimal;
import java.util.Optional;

@Component
public class CurrencyApiClient {
    
    private final RestTemplate restTemplate;
    private static final String API_KEY = "a49222a0fa64e1d13678fbffd6e750ed";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
    
    @Autowired
    public CurrencyApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Cacheable(value = "exchangeRates", key = "#from + '-' + #to")
    public BigDecimal getExchangeRate(String from, String to) {
        try {
            String url = BASE_URL + from.toUpperCase();
            
            ExchangeRateResponseDTO response = restTemplate.getForObject(
                url, 
                ExchangeRateResponseDTO.class
            );
            
            if (response != null && response.conversionRates() != null) {
                Double rate = response.conversionRates().get(to.toUpperCase());
                if (rate != null) {
                    return BigDecimal.valueOf(rate);
                }
                throw new RuntimeException("Taxa de câmbio não encontrada para " + to);
            }
            
            throw new RuntimeException("Resposta inválida da API de câmbio");
        } catch (RestClientException e) {
            throw new RuntimeException("Erro ao consultar API de câmbio: " + e.getMessage(), e);
        }
    }
    
    public Optional<ExchangeRateResponseDTO> getAllRates(String baseCurrency) {
        try {
            String url = BASE_URL + baseCurrency.toUpperCase();
            ExchangeRateResponseDTO response = restTemplate.getForObject(
                url,
                ExchangeRateResponseDTO.class
            );
            return Optional.ofNullable(response);
        } catch (RestClientException e) {
            throw new RuntimeException("Erro ao consultar todas as taxas: " + e.getMessage(), e);
        }
    }
}
