package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private LocalDateTime dataCriacao;

    public Usuario(UUID id, String nome, String email, LocalDateTime dataCriacao) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.dataCriacao = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
