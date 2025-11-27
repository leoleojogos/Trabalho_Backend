package com.example.tripshare.controllers;

import com.example.tripshare.models.dtos.agreementMember.AgreementMemberRequestDTO;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberResponseDTO;
import com.example.tripshare.services.AgreementMemberService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agreement-member")
@RequiredArgsConstructor
public class AgreementMemberController {
    private final AgreementMemberService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AgreementMemberResponseDTO create(
            @Valid @RequestBody AgreementMemberRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/agreement/{agreementId}")
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementMemberResponseDTO> list(@PathVariable UUID agreementId) {
        return service.list(agreementId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementMemberResponseDTO update(
            @PathVariable UUID id,
            @Valid @RequestBody AgreementMemberRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
