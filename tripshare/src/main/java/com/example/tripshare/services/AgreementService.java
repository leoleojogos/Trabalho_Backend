package com.example.tripshare.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripshare.mappers.AgreementMapper;
import com.example.tripshare.repositories.AgreementRepository;
import com.example.tripshare.repositories.PaymentSplitRepository;
import com.example.tripshare.repositories.CategoryRepository;
import com.example.tripshare.models.entities.Agreement;
import com.example.tripshare.models.entities.PaymentSplit;
import com.example.tripshare.models.entities.Category;
import com.example.tripshare.models.dtos.agreement.AgreementRequestDTO;
import com.example.tripshare.models.dtos.agreement.AgreementResponseDTO;

import lombok.RequiredArgsConstructor;
import java.util.UUID;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AgreementService {
    
    private final AgreementRepository agreementRepository;
    private final AgreementMapper agreementMapper;
    private final PaymentSplitRepository paymentSplitRepository;
    private final CategoryRepository categoryRepository;

    @SuppressWarnings("null")
    public AgreementResponseDTO create(AgreementRequestDTO request) {
        PaymentSplit paymentSplit = paymentSplitRepository.findById(request.paymentSplit())
            .orElseThrow(() -> new RuntimeException("PaymentSplit não encontrado com id: " + request.paymentSplit()));
        
        Category category = categoryRepository.findById(request.category())
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + request.category()));
        
        Agreement entity = agreementMapper.toEntity(request);
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
            .orElseThrow(() -> new RuntimeException("Acordo não encontrado com id: " + id));
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
            .orElseThrow(() -> new RuntimeException("Acordo não encontrado com id: " + id));

        if(request.paymentSplit() != null) {
            PaymentSplit paymentSplit = paymentSplitRepository.findById(request.paymentSplit())
                    .orElseThrow(() -> new RuntimeException("PaymentSplit não encontrado com id: " + request.paymentSplit()));
        }

        if(request.category() != null) {
            Category category = categoryRepository.findById(request.category())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + request.category()));
        }

        agreementMapper.update(entity, request);
        Agreement saved = agreementRepository.save(entity);
        return agreementMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public void delete(UUID id) {
        Agreement entity = agreementRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Acordo não encontrado com id: " + id));
        agreementRepository.delete(entity);
    }
}
