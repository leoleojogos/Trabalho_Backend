package com.example.tripshare.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "groups")
@Entity(name = "Group")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Builder.Default
    @NotNull(message = "O valor do atributo 'is_active' não pode ser vazio")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    

}
