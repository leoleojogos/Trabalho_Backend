package com.example.tripshare.models.entities;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
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

    @NotNull(message = "O valor do atributo 'is_creditor' não pode estar vazio")
    @Column(nullable = false)
    private Boolean isCreditor;

}
