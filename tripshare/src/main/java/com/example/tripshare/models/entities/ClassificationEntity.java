package com.example.tripshare.models.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClassificationEntity {
    
    @Id
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "O atributo 'title' não deve estar vazio")
    @Size(max = 100, message = "O atributo 'title' deve ter no máximo 100 caracteres")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "O atributo 'description' não deve estar vazio")
    @Size(max = 100, message = "O atributo 'description' deve ter no máximo 100 caracteres")
    @Column(nullable = false)
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
