package com.example.tripshare.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripshare.mappers.AgreementMapper;
import com.example.tripshare.repositories.AgreementRepository;
import com.example.tripshare.repositories.GroupMemberRepository;
import com.example.tripshare.repositories.PaymentSplitRepository;
import com.example.tripshare.repositories.CategoryRepository;
import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.models.entities.PaymentSplit;
import com.example.tripshare.models.entities.Category;
import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;
import com.example.tripshare.models.dtos.agreement.AgreementReportDTO;

import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementService {
    
    private final AgreementRepository agreementRepository;
    private final AgreementMapper agreementMapper;
    private final GroupMemberRepository groupMemberRepository;
    private final PaymentSplitRepository paymentSplitRepository;
    private final CategoryRepository categoryRepository;

    @SuppressWarnings("null")
    public AgreementResponseDTO create(AgreementRequestDTO request) {
        GroupMember creator = groupMemberRepository.findById(request.createdById())
            .orElseThrow(() -> new RuntimeException("Membro não encontrado com id: " + request.createdById()));
        
        PaymentSplit paymentSplit = paymentSplitRepository.findById(request.paymentSplit())
            .orElseThrow(() -> new RuntimeException("PaymentSplit não encontrado com id: " + request.paymentSplit()));
        
        Category category = categoryRepository.findById(request.category())
            .orElseThrow(() -> new RuntimeException("Category não encontrada com id: " + request.category()));
        
        Agreement entity = agreementMapper.toEntity(request);
        entity.setCreatedBy(creator);
        entity.setPaymentSplit(paymentSplit);
        entity.setCategory(category);
        entity.setExchangeRate(BigDecimal.ONE);
        entity.setIsPaid(false);
        
        Agreement saved = agreementRepository.save(entity);
        return agreementMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public AgreementResponseDTO getById(UUID id) {
        Agreement entity = agreementRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agreement não encontrado com id: " + id));
        return agreementMapper.toDTO(entity);
    }

    @SuppressWarnings("null")
    public Page<AgreementResponseDTO> getAll(Pageable pageable) {
        return agreementRepository.findAll(pageable)
            .map(agreementMapper::toDTO);
    }

    @SuppressWarnings("null")
    public AgreementResponseDTO update(UUID id, AgreementRequestDTO request) {
        Agreement entity = agreementRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agreement não encontrado com id: " + id));
        
        GroupMember creator = groupMemberRepository.findById(request.createdById())
            .orElseThrow(() -> new RuntimeException("Membro não encontrado com id: " + request.createdById()));
        
        PaymentSplit paymentSplit = paymentSplitRepository.findById(request.paymentSplit())
            .orElseThrow(() -> new RuntimeException("PaymentSplit não encontrado com id: " + request.paymentSplit()));
        
        Category category = categoryRepository.findById(request.category())
            .orElseThrow(() -> new RuntimeException("Category não encontrada com id: " + request.category()));
        
        Agreement updated = agreementMapper.toEntity(request);
        updated.setId(entity.getId());
        updated.setCreatedAt(entity.getCreatedAt());
        updated.setCreatedBy(creator);
        updated.setPaymentSplit(paymentSplit);
        updated.setCategory(category);
        updated.setExchangeRate(entity.getExchangeRate());
        updated.setIsPaid(entity.getIsPaid());
        
        Agreement saved = agreementRepository.save(updated);
        return agreementMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public void delete(UUID id) {
        Agreement entity = agreementRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agreement não encontrado com id: " + id));
        agreementRepository.delete(entity);
    }

    public AgreementReportDTO getReport(Integer days) {
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusDays(days != null ? days : 30);
        
        Long totalRecords = agreementRepository.count();
        Long recordsInPeriod = agreementRepository.countByPeriod(start, end);
        Long paidAgreements = agreementRepository.countPaidByPeriod(start, end);
        Long unpaidAgreements = agreementRepository.countUnpaidByPeriod(start, end);
        
        List<Agreement> agreementsInPeriod = agreementRepository.findByCreatedAtBetween(start, end);
        BigDecimal totalAmount = agreementsInPeriod.stream()
            .map(a -> BigDecimal.ZERO)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        return new AgreementReportDTO(
            totalRecords,
            recordsInPeriod,
            totalAmount,
            paidAgreements,
            unpaidAgreements,
            start,
            end
        );
    }
}
