package com.example.tripshare.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.tripshare.services.AgreementService;
import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@RestController
@RequestMapping("/api/agreements")
@RequiredArgsConstructor
public class AgreementController {
    
    private final AgreementService agreementService;

    @PostMapping
    public ResponseEntity<AgreementResponseDTO> create(@Valid @RequestBody AgreementRequestDTO request) {
        AgreementResponseDTO response = agreementService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgreementResponseDTO> getById(@PathVariable UUID id) {
        AgreementResponseDTO response = agreementService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<AgreementResponseDTO>> getAll(Pageable pageable) {
        Page<AgreementResponseDTO> response = agreementService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgreementResponseDTO> update(@PathVariable UUID id, @Valid @RequestBody AgreementRequestDTO request) {
        AgreementResponseDTO response = agreementService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        agreementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
