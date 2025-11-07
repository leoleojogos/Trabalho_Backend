package com.example.tripshare.models.entities;

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

@Table(name = "groups")
@Entity
@Data
@Builder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Group extends AuditableEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "O atributo 'name' não pode estar vazio")
    @Size(max = 100, message = "O valor de 'name' deve ter no máximo 100 caracteres")
    @Column(nullable = false)
    private String name;

    @Size(max = 200)
    private String description;

    @NotBlank(message = "O valor do atributo 'currency_code' não pode estar vazio")
    @Size(min = 3, max = 3)
    @Column(nullable = false)
    private String currencyCode;

    @Builder.Default
    @NotNull(message = "O valor do atributo 'is_active' não pode ser vazio")
    @Column(nullable = false)
    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor de 'created_id' não pode estar vazio")
    private User createdBy;

}
