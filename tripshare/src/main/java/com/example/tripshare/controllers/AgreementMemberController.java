package com.example.tripshare.controllers;

import com.example.tripshare.models.dtos.agreementMember.AgreementMemberRequestDTO;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberResponseDTO;
import com.example.tripshare.models.entities.AgreementMember;
import com.example.tripshare.services.AgreementMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AgreementMemberController {
    private final AgreementMemberService service;

    @PostMapping("/agreements/{agreementId}/divisions")
    public ResponseEntity<AgreementMemberResponseDTO> create(
            @PathVariable UUID agreementId,
            @RequestBody AgreementMemberRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(agreementId, dto));
    }

    @GetMapping("/agreements/{agreementId}/divisions")
    public List<AgreementMemberResponseDTO> list(@PathVariable UUID agreementId) {
        return service.list(agreementId);
    }

    @PutMapping("/divisions/{id}")
    public AgreementMemberResponseDTO update(
            @PathVariable UUID id,
            @RequestBody AgreementMemberRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/divisions/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
