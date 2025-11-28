package com.example.tripshare.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.tripshare.services.AgreementService;
import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;
import com.example.tripshare.models.dtos.agreement.AgreementReportDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/report")
    public ResponseEntity<AgreementReportDTO> getReport(@RequestParam(required = false) Integer periodo) {
        AgreementReportDTO report = agreementService.getReport(periodo);
        return ResponseEntity.ok(report);
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
