package com.example.tripshare.services;

import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.models.entities.AgreementMember;
import com.example.tripshare.models.entities.GroupMember;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AgreementMemberService {
    private final List<AgreementMember> divisions = new ArrayList<>();

    public List<AgreementMember> getDivisionsByAgreement(UUID agreementId) {
        return divisions.stream()
                .filter(d -> d.getAgreementId().getId().equals(agreementId))
                .collect(Collectors.toList());
    }
}

public AgreementMember createDivision(GroupMember member, Agreement agreement, BigDecimal amount, Boolean isCreditor) {
    AgreementMember division = new AgreementMember(member, agreement, amount, isCreditor);
    divisions.add(division);
    return division;
}

public Optional<AgreementMember> updateDivision(UUID id, BigDecimal amount, Boolean isCreditor) {
    return divisions.stream()
            .filter(d -> d.getId().equals(id))
            .findFirst()
            .map(d -> {
                d.setAmount(amount);
                d.setIsCreditor(isCreditor);
                return d;
            });
}

public boolean deleteDivision(UUID id) {
    return divisions.removeIf(d -> d.getId().equals(id));
}