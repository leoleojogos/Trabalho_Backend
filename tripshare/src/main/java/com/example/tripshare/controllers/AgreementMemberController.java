package com.example.tripshare.controllers;

import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.services.AgreementMemberService;
import com.example.tripshare.models.entities.AgreementMember;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AgreementMemberController {
    private final AgreementMemberService service;

    @GetMapping("/agreements/{agreementId}/divisions")
    public List<AgreementMember> listDivisions(@PathVariable UUID agreementId) {
        return service.getDivisionsByAgreement(agreementId);
    }

    @PostMapping("/agreements/{agreementId}/divisions")
    public AgreementMember addDivision(
            @PathVariable UUID agreementId,
            @RequestBody Map<String, Object> body
    ) {
        Agreement agreement = new Agreement();
        agreement.setId(agreementId);

        GroupMember member = new GroupMember();
        member.setId(UUID.fromString(body.get("memberId").toString()));

        BigDecimal amount = new BigDecimal(body.get("amount").toString());
        Boolean isCreditor = Boolean.valueOf(body.get("isCreditor").toString());

        return service.createDivision(member, agreement, amount, isCreditor);
    }

    @PutMapping("/divisions/{id}")
    public Optional<AgreementMember> updateDivision(
            @PathVariable UUID id,
            @RequestBody Map<String, Object> body
    ) {
        BigDecimal amount = new BigDecimal((body.get("amount").toString()));
        Boolean isCreditor = Boolean.valueOf(body.get("isCreditor").toString());
        return service.updateDivision(id, amount, isCreditor);
    }

    @DeleteMapping("/divisions/{id}")
    public String deleteDivision(@PathVariable UUID id) {
        boolean removed = service.deleteDivision(id);
        return removed ? "Divisão removida" : "Divisão não encontrada";
    }
}

