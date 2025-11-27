package com.example.tripshare.services;

import com.example.tripshare.mappers.AgreementMemberMapper;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberRequestDTO;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberResponseDTO;
import com.example.tripshare.models.entities.*;

import com.example.tripshare.repositories.*;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementMemberService {
    private final AgreementMemberRepository repository;
    private final AgreementRepository agreementRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final AgreementMemberMapper mapper;

    public AgreementMemberResponseDTO create(AgreementMemberRequestDTO dto) {

        // Validar entidades
        Agreement agreement = agreementRepository.findById(dto.agreementId())
                .orElseThrow(() -> new EntityNotFoundException("Acordo não encontrado"));

        GroupMember member = groupMemberRepository.findById(dto.memberId())
                .orElseThrow(() -> new EntityNotFoundException("Membro não encontrado"));

        // Converter
        AgreementMember entity = mapper.toEntity(dto);
        entity.setAgreementId(agreement.getId());
        entity.setMemberId(member.getId());

        repository.save(entity);

        return enrich(mapper.toResponseDTO(entity), member);
    }

    public List<AgreementMemberResponseDTO> listByAgreement(UUID agreementId) {

        List<AgreementMember> list = repository.findByAgreementId(agreementId);

        return list.stream().map(entity -> {
            GroupMember member = groupMemberRepository.findById(entity.getMemberId())
                    .orElseThrow(() -> new EntityNotFoundException("Membro não encontrado"));
            return enrich(mapper.toResponseDTO(entity), member);
        }).toList();
    }

    public AgreementMemberResponseDTO update(UUID id, AgreementMemberRequestDTO dto) {

        AgreementMember entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AgreementMember não encontrado"));

        Agreement agreement = agreementRepository.findById(dto.agreementId())
                .orElseThrow(() -> new EntityNotFoundException("Acordo não encontrado"));

        GroupMember member = groupMemberRepository.findById(dto.memberId())
                .orElseThrow(() -> new EntityNotFoundException("Membro não encontrado"));

        entity.setAgreementId(dto.agreementId());
        entity.setMemberId(dto.memberId());
        entity.setAmount(dto.amount());
        entity.setIsCreditor(dto.isCreditor());

        repository.save(entity);

        return enrich(mapper.toResponseDTO(entity), member);
    }

    public void delete(UUID id) {
        AgreementMember entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AgreementMember não encontrado"));
        repository.delete(entity);
    }

    private AgreementMemberResponseDTO enrich(
            AgreementMemberResponseDTO dto,
            GroupMember member
    ) {

        return new AgreementMemberResponseDTO(
                dto.id(),
                member.getUserId().getName(),   // memberName
                member.getGroupId().getName(),    // groupName
                dto.isCreditor(),
                dto.amount()
        );
    }
}
