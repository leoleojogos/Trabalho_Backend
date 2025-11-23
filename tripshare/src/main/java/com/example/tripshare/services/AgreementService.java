package com.example.tripshare.services;

import com.example.tripshare.mappers.AgreementMapper;
import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;
import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.models.entities.Group;
import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.repositories.AgreementRepository;

import com.example.tripshare.repositories.GroupMemberRepository;
import com.example.tripshare.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementService {
    private final AgreementRepository agreementRepository;
    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final AgreementMapper agreementMapper;

    public AgreementResponseDTO createAgreement(UUID groupId, AgreementRequestDTO dto) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));

        GroupMember creator = groupMemberRepository.findById(dto.getCreatedById())
                .orElseThrow(() -> new RuntimeException("Creator not found"));

        Agreement agreement = agreementMapper.toEntity(dto);
        agreement.setGroup(group);
        agreement.setCreatedBy(creator);
        agreementRepository.save(agreement);

        return agreementMapper.toResponseDTO(agreement);
    }

    public List<AgreementResponseDTO> listAgreements(UUID groupId) {
        List<Agreement> agreements = agreementRepository.findByGroupId(groupId);
        return agreements.stream()
                .map(agreementMapper::toResponseDTO)
                .toList();
    }

    public AgreementResponseDTO getAgreement(UUID id) {
        Agreement agreement = agreementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acordo não encontrado"));
        return agreementMapper.toResponseDTO(agreement);
    }

    public AgreementResponseDTO updateAgreement(UUID id, AgreementRequestDTO dto) {
        Agreement agreement = agreementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acordo não encontrado"));

        if (!agreement.getCreatedBy().getUserId().getId().equals(dto.getRequestingUserId())
                && !agreement.getCreatedBy().getIsAdmin()) {
            throw new RuntimeException("Not allowed to edit");
        }
        agreementMapper.updateEntity(agreement, dto);
        agreementRepository.save(agreement);
        return agreementMapper.toResponseDTO(agreement);
    }

    public void deleteAgreement(UUID id) {
        Agreement agreement = agreementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acordo não encontrado"));
        agreementRepository.delete(agreement);
    }
}
