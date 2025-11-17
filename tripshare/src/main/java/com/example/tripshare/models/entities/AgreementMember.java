package com.example.tripshare.models.entities;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "agreement_members")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AgreementMember {
    
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor do campo 'member_id' não pode estar vazio")
    private GroupMember memberId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor do campo 'agreement_id' não pode estar vazio")
    private Agreement agreementId;

    @NotNull(message = "O valor do atributo 'amount' não pode estar vazio")
    @Column(precision = 14, scale = 2, nullable = false)
    private BigDecimal amount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GroupMember getMemberId() {
        return memberId;
    }

    public void setMemberId(GroupMember memberId) {
        this.memberId = memberId;
    }

    public Agreement getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Agreement agreementId) {
        this.agreementId = agreementId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
