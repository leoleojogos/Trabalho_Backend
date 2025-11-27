package com.example.tripshare.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.tripshare.services.CurrencyService;
import com.example.tripshare.models.dtos.currency.CurrencyConversionRequestDTO;
import com.example.tripshare.models.dtos.currency.CurrencyConversionResponseDTO;
import com.example.tripshare.models.dtos.currency.ExchangeRateResponseDTO;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/currency")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurrencyController {
    
    private final CurrencyService currencyService;
    
    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
    
    /**
     * Converte um valor de uma moeda para outra
     * @param request DTO com moedas de origem/destino e valor
     * @return Resposta com valor convertido e taxa de câmbio
     */
    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversionResponseDTO> convertCurrency(
            @Valid @RequestBody CurrencyConversionRequestDTO request) {
        try {
            CurrencyConversionResponseDTO response = currencyService.convertCurrency(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Obtém a taxa de câmbio entre duas moedas
     * @param from Moeda de origem
     * @param to Moeda de destino
     * @return Taxa de câmbio
     */
    @GetMapping("/rate")
    public ResponseEntity<?> getExchangeRate(
            @RequestParam(name = "from") String from,
            @RequestParam(name = "to") String to) {
        try {
            var rate = currencyService.getExchangeRate(from, to);
            return ResponseEntity.ok()
                .body(java.util.Map.of(
                    "from", from.toUpperCase(),
                    "to", to.toUpperCase(),
                    "rate", rate
                ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                .body(java.util.Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(java.util.Map.of("error", "Erro ao buscar taxa de câmbio"));
        }
    }
    
    /**
     * Obtém todas as taxas de câmbio para uma moeda base
     * @param baseCurrency Moeda base
     * @return DTO com todas as taxas disponíveis
     */
    @GetMapping("/rates/{baseCurrency}")
    public ResponseEntity<?> getAllRates(@PathVariable String baseCurrency) {
        try {
            var rates = currencyService.getAllRates(baseCurrency);
            return ResponseEntity.ok(rates);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                .body(java.util.Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(java.util.Map.of("error", "Erro ao buscar taxas de câmbio"));
        }
    }
}
