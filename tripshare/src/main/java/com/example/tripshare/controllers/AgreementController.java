package com.example.tripshare.controllers;

import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.services.AgreementService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AgreementController {
    private final AgreementService service;

    public AgreementController(AgreementService service) {
        this.service = service;
    }

    @PostMapping("/grupos/{grupoId}/acordos")
    public Agreement create(
            @PathVariable UUID groupId,
            @RequestBody Agreement agreement
            ) {
        return service.createAgreement(groupId, agreement);
    }

    @GetMapping("/acordos/{id}")
    public Agreement getOne(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/acordos/{id}")
    public Agreement update(
            @PathVariable UUID id,
            @RequestBody Agreement agreement
    ) {
        return service.updateAgreement(id, agreement);
    }

    @DeleteMapping("/acordos/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteAgreement(id);
    }

    @GetMapping("/group/{groupId}/saldos")
    public String getSaldos(@PathVariable UUID grupoId) {
        return service.calculateBalances(grupoId);
    }

    @PatchMapping("group/{groupId}/saldos/reiniciar")
    public String reset(@PathVariable UUID grupoId) {
        return service.resetBalances(grupoId);
    }
}
