package com.example.tripshare.controllers;

import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;
import com.example.tripshare.services.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @PostMapping("/groups/{groupId}/agreements")
    public ResponseEntity<AgreementResponseDTO> createAgreement(
            @PathVariable UUID groupId,
            @RequestBody AgreementRequestDTO dto) {
        AgreementResponseDTO response = agreementService.createAgreement(groupId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/groups/{groupId}/agreements")
    public List<AgreementResponseDTO> listGroupAgreements(@PathVariable UUID groupId) {
        return agreementService.listAgreement(groupId);
    }

    @GetMapping("/agreements/{id}")
    public AgreementResponseDTO getAgreement(@PathVariable UUID id) {
        return agreementService.getAgreement(id);
    }

    @PutMapping("/agreements/{id}")
    public AgreementResponseDTO updateAgreement(
            @PathVariable UUID id,
            @RequestBody AgreementRequestDTO dto
    ) {
        return agreementService.updateAgreement(id, dto);
    }

    @DeleteMapping("/agreements/{id}")
    public ResponseEntity<Void> deleteAgreement(@PathVariable UUID id) {
        agreementService.deleteAgreement(id);
        return ResponseEntity.noContent().build();
    }
}
