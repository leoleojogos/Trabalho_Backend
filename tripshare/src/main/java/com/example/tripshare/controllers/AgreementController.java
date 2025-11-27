package com.example.tripshare.controllers;

import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;
import com.example.tripshare.services.AgreementService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agreement")
@RequiredArgsConstructor
public class AgreementController {
    private final AgreementService service;

    @PostMapping("/creator/{creatorId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementResponseDTO create(
            @PathVariable UUID creatorId,
            @Valid @RequestBody AgreementRequestDTO dto) {
        return service.create(creatorId, dto);
    }

    @GetMapping("/creator/{creatorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementResponseDTO> listByCreator(@PathVariable UUID creatorId) {
        return service.listByCreator(creatorId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementResponseDTO get(@PathVariable UUID id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementResponseDTO update(
            @PathVariable UUID id,
            @Valid @RequestBody AgreementRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
