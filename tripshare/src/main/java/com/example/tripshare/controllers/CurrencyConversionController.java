package com.example.tripshare.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tripshare.services.CurrencyService;
import com.example.tripshare.models.dtos.currency.CurrencyConversionRequestDTO;
import com.example.tripshare.models.dtos.currency.CurrencyConversionResponseDTO;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/currencies")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurrencyConversionController {

    private final CurrencyService currencyService;

    @PostMapping("/convert")
    public ResponseEntity<?> convert(
            @Valid @RequestBody CurrencyConversionRequestDTO request) {
        try {
            System.out.println("Request recebido: " + request);
            CurrencyConversionResponseDTO response = currencyService.convertCurrency(request);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            System.err.println("Erro no convert: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(java.util.Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/rate")
    public ResponseEntity<Map<String, Object>> getRate(
            @RequestParam(name = "from") String fromCurrency,
            @RequestParam(name = "to") String toCurrency) {
        
        BigDecimal rate = currencyService.getExchangeRate(fromCurrency, toCurrency);
        
        return ResponseEntity.ok(Map.of(
            "from", fromCurrency.toUpperCase(),
            "to", toCurrency.toUpperCase(),
            "rate", rate,
            "lastUpdated", LocalDateTime.now()
        ));
    }

    @GetMapping("/convert/{from}/{to}/{amount}")
    public ResponseEntity<CurrencyConversionResponseDTO> convertPath(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal amount) {
        
        CurrencyConversionRequestDTO request = new CurrencyConversionRequestDTO(from, to, amount);
        CurrencyConversionResponseDTO response = currencyService.convertCurrency(request);
        return ResponseEntity.ok(response);
    }
}
