package com.example.tripshare.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripshare.models.entities.AgreementMember;

public interface AgreementMemberRepository extends JpaRepository<AgreementMember, UUID>{
    List<AgreementMember> findByAgreementId(UUID agreementId);
}