package com.example.tripshare.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripshare.mappers.AgreementMemberMapper;
import com.example.tripshare.repositories.AgreementMemberRepository;
import com.example.tripshare.repositories.GroupMemberRepository;
import com.example.tripshare.repositories.AgreementRepository;
import com.example.tripshare.models.entities.AgreementMember;
import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberRequestDTO;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberResponseDTO;

import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementMemberService {
    
    private final AgreementMemberRepository agreementMemberRepository;
    private final AgreementMemberMapper agreementMemberMapper;
    private final GroupMemberRepository groupMemberRepository;
    private final AgreementRepository agreementRepository;

    @SuppressWarnings("null")
    public AgreementMemberResponseDTO create(AgreementMemberRequestDTO request) {
        GroupMember member = groupMemberRepository.findById(request.memberId())
            .orElseThrow(() -> new RuntimeException("Membro do grupo não encontrado com id: " + request.memberId()));
        
        Agreement agreement = agreementRepository.findById(request.agreementId())
            .orElseThrow(() -> new RuntimeException("Acordo não encontrado com id: " + request.agreementId()));
        
        AgreementMember entity = agreementMemberMapper.toEntity(request);
        entity.setMemberId(member);
        entity.setAgreementId(agreement);
        
        AgreementMember saved = agreementMemberRepository.save(entity);
        return agreementMemberMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public AgreementMemberResponseDTO getById(UUID id) {
        AgreementMember entity = agreementMemberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Membro do acordo não encontrado com id: " + id));
        return agreementMemberMapper.toDTO(entity);
    }

    @SuppressWarnings("null")
    public Page<AgreementMemberResponseDTO> getAll(Pageable pageable) {
        return agreementMemberRepository.findAll(pageable)
            .map(agreementMemberMapper::toDTO);
    }

    @SuppressWarnings("null")
    public AgreementMemberResponseDTO update(UUID id, AgreementMemberRequestDTO request) {
        AgreementMember entity = agreementMemberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Membro do acordo não encontrado com id: " + id));
        
        GroupMember member = groupMemberRepository.findById(request.memberId())
            .orElseThrow(() -> new RuntimeException("Membro do grupo não encontrado com id: " + request.memberId()));
        
        Agreement agreement = agreementRepository.findById(request.agreementId())
            .orElseThrow(() -> new RuntimeException("Acordo não encontrado com id: " + request.agreementId()));
        
        entity.setMemberId(member);
        entity.setAgreementId(agreement);
        entity.setAmount(request.amount());
        entity.setIsCreditor(request.isCreditor());
        
        AgreementMember saved = agreementMemberRepository.save(entity);
        return agreementMemberMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public void delete(UUID id) {
        AgreementMember entity = agreementMemberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Membro do acordo não encontrado com id: " + id));
        agreementMemberRepository.delete(entity);
    }
}
