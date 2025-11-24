package com.example.tripshare.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripshare.mappers.PaymentSplitMapper;
import com.example.tripshare.repositories.PaymentSplitRepository;
import com.example.tripshare.models.entities.PaymentSplit;
import com.example.tripshare.models.dtos.paymentSplit.PaymentSplitRequestDTO;
import com.example.tripshare.models.dtos.paymentSplit.PaymentSplitResponseDTO;

import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentSplitService {
    
    private final PaymentSplitRepository paymentSplitRepository;
    private final PaymentSplitMapper paymentSplitMapper;

    @SuppressWarnings("null")
    public PaymentSplitResponseDTO create(PaymentSplitRequestDTO request) {
        PaymentSplit entity = paymentSplitMapper.toEntity(request);
        PaymentSplit saved = paymentSplitRepository.save(entity);
        return paymentSplitMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public PaymentSplitResponseDTO getById(UUID id) {
        PaymentSplit entity = paymentSplitRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("PaymentSplit não encontrado com id: " + id));
        return paymentSplitMapper.toDTO(entity);
    }

    @SuppressWarnings("null")
    public Page<PaymentSplitResponseDTO> getAll(Pageable pageable) {
        return paymentSplitRepository.findAll(pageable)
            .map(paymentSplitMapper::toDTO);
    }

    @SuppressWarnings("null")
    public PaymentSplitResponseDTO update(UUID id, PaymentSplitRequestDTO request) {
        PaymentSplit entity = paymentSplitRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("PaymentSplit não encontrado com id: " + id));
        
        PaymentSplit updated = paymentSplitMapper.toEntity(request);
        updated.setId(entity.getId());
        
        PaymentSplit saved = paymentSplitRepository.save(updated);
        return paymentSplitMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public void delete(UUID id) {
        PaymentSplit entity = paymentSplitRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("PaymentSplit não encontrado com id: " + id));
        paymentSplitRepository.delete(entity);
    }
}
