package com.example.tripshare.services;

import com.example.tripshare.mappers.AgreementMapper;
import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;
import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.models.entities.Category;
import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.models.entities.PaymentSplit;
import com.example.tripshare.repositories.AgreementRepository;
import com.example.tripshare.repositories.CategoryRepository;
import com.example.tripshare.repositories.GroupMemberRepository;
import com.example.tripshare.repositories.PaymentSplitRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementService {
    private final AgreementRepository agreementRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final PaymentSplitRepository paymentSplitRepository;
    private final CategoryRepository categoryRepository;

    private final AgreementMapper mapper;

    public AgreementResponseDTO createAgreement(UUID creatorId, AgreementRequestDTO dto) {

        GroupMember creator = groupMemberRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("Criador não encontrado"));

        PaymentSplit paymentSplit = paymentSplitRepository.findById(dto.paymentSplit())
                .orElseThrow(() -> new RuntimeException("Tipo de pagamento não encontrado"));

        Category category = categoryRepository.findById(dto.category())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Agreement entity = mapper.toEntity(dto);

        entity.setCreatedBy(creator);
        entity.setPaymentSplit(paymentSplit);
        entity.setCategory(category);
        entity.setExchangeRate(BigDecimal.ONE);
        entity.setIsPaid(false);

        agreementRepository.save(entity);

        return enrichResponse(mapper.toDTO(entity), entity);
    }

    public List<AgreementResponseDTO> listAgreement(UUID creatorId) {
        List<Agreement> agreements = agreementRepository.findAll()
                .stream()
                .filter(a -> a.getCreatedBy().getId().equals(creatorId))
                .toList();

        return agreements.stream()
                .map(a -> enrichResponse(mapper.toDTO(a), a))
                .toList();
    }

    public AgreementResponseDTO getAgreement(UUID id) {
        Agreement entity = agreementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acordo não encontrado"));

        return enrichResponse(mapper.toDTO(entity), entity);
    }

    public AgreementResponseDTO updateAgreement(UUID id, AgreementRequestDTO dto) {

        Agreement entity = agreementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acordo não encontrado"));

        PaymentSplit paymentSplit = paymentSplitRepository.findById(dto.paymentSplit())
                .orElseThrow(() -> new RuntimeException("Tipo de pagamento não encontrado"));

        Category category = categoryRepository.findById(dto.category())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setCurrencyCode(dto.currencyCode());
        entity.setPaymentSplit(paymentSplit);
        entity.setCategory(category);

        agreementRepository.save(entity);

        return enrichResponse(mapper.toDTO(entity), entity);
    }

    public void deleteAgreement(UUID id) {
        Agreement entity = agreementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acordo não encontrado"));

        agreementRepository.delete(entity);
    }

    private AgreementResponseDTO enrichResponse(AgreementResponseDTO dto, Agreement entity) {
        return new AgreementResponseDTO(
                dto.id(),
                dto.title(),
                entity.getCreatedBy().getUserId().getName(),
                dto.description(),
                dto.currencyCode(),
                dto.isPaid(),
                entity.getPaymentSplit().getTitle(),
                entity.getCategory().getTitle(),
                dto.createdAt()
        );
    }
}
