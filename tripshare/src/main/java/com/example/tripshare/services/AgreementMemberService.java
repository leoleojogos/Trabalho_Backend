package com.example.tripshare.services;

import com.example.tripshare.mappers.AgreementMemberMapper;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberRequestDTO;
import com.example.tripshare.models.dtos.agreementMember.AgreementMemberResponseDTO;
import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.models.entities.AgreementMember;
import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.repositories.AgreementMemberRepository;
import com.example.tripshare.repositories.AgreementRepository;
import com.example.tripshare.repositories.GroupMemberRepository;
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

    public AgreementMemberResponseDTO create(UUID agreementId, AgreementMemberRequestDTO dto) {
        Agreement agreement = agreementRepository.findById(agreementId)
                .orElseThrow(() -> new RuntimeException("Acordo não encontrado"));

        GroupMember member = groupMemberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new RuntimeException("Membro do Grupo não encontrado"));

        AgreementMember entity = mapper.toEntity(dto, member, agreement);
        repository.save(entity);

        return mapper.toResponseDTO(entity);
    }

    public List<AgreementMemberResponseDTO> list(UUID agreementId) {
        List<AgreementMember> list = repository.findByAgreementId(agreementId);
        return list.stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public AgreementMemberResponseDTO update(UUID id, AgreementMemberResponseDTO dto) {
        AgreementMember entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro do Acordo não encontrado"));

        GroupMember member = groupMemberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new RuntimeException("Membro do Grupo não encotrado"));

        mapper.updateEntity(entity, dto, member);
        repository.save(entity);

        return mapper.toResponseDTO(entity);
    }

    public void delete(UUID id) {
        AgreementMember entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro do Grupo não encontrado"));

        repository.delete(entity);
    }
}
