package com.example.tripshare.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.tripshare.services.PaymentSplitService;
import com.example.tripshare.models.dtos.paymentSplit.PaymentSplitRequestDTO;
import com.example.tripshare.models.dtos.paymentSplit.PaymentSplitResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment-splits")
@RequiredArgsConstructor
public class PaymentSplitController {
    
    private final PaymentSplitService paymentSplitService;

    @PostMapping
    public ResponseEntity<PaymentSplitResponseDTO> create(@Valid @RequestBody PaymentSplitRequestDTO request) {
        PaymentSplitResponseDTO response = paymentSplitService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentSplitResponseDTO> getById(@PathVariable UUID id) {
        PaymentSplitResponseDTO response = paymentSplitService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<PaymentSplitResponseDTO>> getAll(Pageable pageable) {
        Page<PaymentSplitResponseDTO> response = paymentSplitService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PaymentSplitResponseDTO> update(@PathVariable UUID id, @RequestBody PaymentSplitRequestDTO request) {
        PaymentSplitResponseDTO response = paymentSplitService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        paymentSplitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
