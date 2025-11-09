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

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "agreements")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Agreement extends AuditableEntity{

    @Id
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "O valor do atributo 'title' não pode estar vazio")
    @Size(max = 200, message = "O atributo 'title' de 'Agreement' deve ter no máximo 200 caracteres")
    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor do campo 'created_by' não pode estar vazio")
    private GroupMember createdBy;

    @NotBlank(message = "O valor do atributo 'description' não pode estar vazio")
    @Size(max = 200, message = "O valor do atributo 'description' é de no máximo 200 caracteres")
    @Column(length = 200)
    private String description;

    @NotBlank(message = "O valor do atributo 'currency_code' não pode estar vazio")
    @Size(min = 3, max = 3, message = "O atributo 'currency_code' deve ter 3 caracteres")
    @Column(length = 3, nullable = false)
    private String currencyCode;

    @NotNull(message = "O valor do atributo 'exchange_rate' não pode estar vazio")
    @Column(precision = 15, scale = 6, nullable = false)
    private BigDecimal exchangeRate;

    @NotNull(message = "O valor do atributo 'is_paid' não pode estar vazio")
    private Boolean isPaid;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor de 'payment_split' não pode estar vazio")
    private PaymentSplit paymentSplit;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor de 'category' não pode estar vazio")
    private Category category;
    
}
