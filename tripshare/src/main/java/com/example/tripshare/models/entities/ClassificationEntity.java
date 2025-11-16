package com.example.tripshare.models.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class ClassificationEntity {
    
    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "O atributo 'title' não deve estar vazio")
    @Size(max = 100, message = "O atributo 'title' deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String title;

    @NotBlank(message = "O atributo 'description' não deve estar vazio")
    @Size(max = 200, message = "O atributo 'description' deve ter no máximo 200 caracteres")
    @Column(nullable = false, length = 200)
    private String description;

}
