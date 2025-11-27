package com.example.tripshare.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.tripshare.models.dtos.currency.CurrencyConversionRequestDTO;
import com.example.tripshare.models.dtos.currency.CurrencyConversionResponseDTO;

import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final RestTemplate restTemplate;
    private static final String API_URL = "https://api.exchangerate.host/convert?access_key=a49222a0fa64e1d13678fbffd6e750ed&from=";

    public CurrencyConversionResponseDTO convertCurrency(CurrencyConversionRequestDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser null");
        }
        
        if (request.from() == null || request.from().isBlank()) {
            throw new IllegalArgumentException("Moeda de origem não pode ser vazia");
        }
        
        if (request.to() == null || request.to().isBlank()) {
            throw new IllegalArgumentException("Moeda de destino não pode ser vazia");
        }
        
        if (request.amount() == null || request.amount().signum() <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        
        String fromCode = request.from().toUpperCase();
        String toCode = request.to().toUpperCase();
        
        if (fromCode.equals(toCode)) {
            return new CurrencyConversionResponseDTO(
                fromCode,
                toCode,
                request.amount(),
                request.amount(),
                BigDecimal.ONE
            );
        }
        
        BigDecimal exchangeRate = getExchangeRate(fromCode, toCode);
        BigDecimal convertedAmount = request.amount()
            .multiply(exchangeRate)
            .setScale(2, RoundingMode.HALF_UP);
        
        return new CurrencyConversionResponseDTO(
            fromCode,
            toCode,
            request.amount(),
            convertedAmount,
            exchangeRate.setScale(6, RoundingMode.HALF_UP)
        );
    }
    
    public BigDecimal getExchangeRate(String from, String to) {
        try {
            String url = API_URL + from.toUpperCase() + "&to=" + to.toUpperCase() + "&amount=1";
            String response = restTemplate.getForObject(url, String.class);
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            
            if (root.get("success").asBoolean()) {
                return BigDecimal.valueOf(root.get("result").asDouble());
            }
            
            throw new RuntimeException("Taxa não encontrada para " + to);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar taxa: " + e.getMessage());
        }
    }
    
    public java.util.Map<String, Object> getAllRates(String baseCurrency) {
        try {
            String url = "https://api.exchangerate.host/live?access_key=a49222a0fa64e1d13678fbffd6e750ed&currencies=" + baseCurrency.toUpperCase();
            String response = restTemplate.getForObject(url, String.class);
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            
            return mapper.convertValue(root, java.util.Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todas as taxas: " + e.getMessage());
        }
    }
}
