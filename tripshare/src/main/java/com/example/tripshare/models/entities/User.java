package com.example.tripshare.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="users")
@Entity
@EqualsAndHashCode(of = "id", callSuper = false)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")
public class User extends AuditableEntity {    

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "O campo 'name' não pode estar vazio")
    @Size(max = 100, message = "O campo 'name' não pode ter mais de 100 caracteres")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "O campo 'email' não pode estar vazio")
    @Size(max = 150, message = "O campo 'email' não pode ter mais de 150 caracteres")
    @Email(message = "O valor do campo 'email' é inválido")
    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @NotBlank(message = "O campo 'password' não pode estar vazio")
    @Size(max = 60, message = "O campo 'password' deve ter no máximo 60 caracteres")
    @Column(nullable = false, length = 60)
    @JsonIgnore
    private String password;

}
