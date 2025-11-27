package com.example.tripshare.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.tripshare.services.AgreementMemberService;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberRequestDTO;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@RestController
@RequestMapping("/api/agreement-members")
@RequiredArgsConstructor
public class AgreementMemberController {
    
    private final AgreementMemberService agreementMemberService;

    @PostMapping
    public ResponseEntity<AgreementMemberResponseDTO> create(@Valid @RequestBody AgreementMemberRequestDTO request) {
        AgreementMemberResponseDTO response = agreementMemberService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgreementMemberResponseDTO> getById(@PathVariable UUID id) {
        AgreementMemberResponseDTO response = agreementMemberService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<AgreementMemberResponseDTO>> getAll(Pageable pageable) {
        Page<AgreementMemberResponseDTO> response = agreementMemberService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AgreementMemberResponseDTO> update(@PathVariable UUID id, @RequestBody AgreementMemberRequestDTO request) {
        AgreementMemberResponseDTO response = agreementMemberService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        agreementMemberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
