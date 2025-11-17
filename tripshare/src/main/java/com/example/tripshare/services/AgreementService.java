package com.example.tripshare.services;

import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.repositories.AgreementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AgreementService {
    private final AgreementRepository repository;

    public AgreementService(AgreementRepository repository) {
        this.repository = repository;
    }

    public Agreement createAgreement(UUID groupId, Agreement agreement) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        agreement.setGroup(group); // <-- única linha essencial

        return agreementRepository.save(agreement);
    }


    public List<Agreement> getAgreementsByGroup(UUID groupId) {
        return agreementRepository.findByGroupId(groupId);
    }


    public Agreement getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agreement not found"));
    }

    public Agreement updateAgreement(UUID id, Agreement newData) {
        Agreement existing = getById(id);

        existing.setTitle(newData.getTitle());
        existing.setDescription(newData.getDescription());
        existing.setCategory(newData.getCategory());
        existing.setCurrencyCode(newData.getCurrencyCode());
        existing.setExchangeRate(newData.getExchangeRate());
        existing.setPaymentSplit(newData.getPaymentSplit());
        existing.setPaid(newData.getPaid());

        return repository.save(existing);
    }

    public void deleteAgreement(UUID id) {
        repository.delete(id);
    }

    public String calculateBalances(UUID groupId) {
        return "Saldos calculados para o grupo " + groupId;
    }

    public String resetBalances(UUID groupId) {
        return "Saldos do grupo " + groupId + " foram reiniciados";
    }
}
