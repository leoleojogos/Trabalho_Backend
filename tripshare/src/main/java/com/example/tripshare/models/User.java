package com.example.tripshare.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

import java.util.UUID;

@Table(name="user")
@Entity(name="user")
@EqualsAndHashCode(of = "id")
@Getter
@AllArgsConstructor
public class User {    

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo 'name' não pode estar vazio")
    @Size(max = 100, message = "O campo 'name' não pode ter mais de 100 caracteres")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "O campo 'email' não pode estar vazio")
    @Size(max = 150, message = "O campo 'email' não pode ter mais de 150 caracteres")
    @Column(nullable = false, length = 150)
    private String email;

    @NotBlank(message = "O campo 'password' não pode estar vazio")
    @Size(min = 8, max = 255, message = "O campo 'password' deve ter entre 8 a 255 caracteres")
    @Column(nullable = false, length = 255)
    private String password;

    @NotNull(message =  "O campo 'created_at' não pode estar vazio")
    @Column(nullable = false)
    private LocalDateTime created_at;

    @NotNull(message =  "O campo 'updated_at' não pode estar vazio")
    @Column(nullable = false)
    private LocalDateTime updated_at;

}
