package com.example.tripshare.models;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

public class Acordo {
    private UUID id;
    private UUID grupoId;
    private UUID devedorId;
    private UUID credorId;
    private double valor;
    private LocalDateTime data;
    private String descricao;

    public Acordo(UUID id, UUID grupoId, UUID devedorId, UUID credorId, double valor, LocalDateTime data, String descricao) {
        this.id = id;
        this.grupoId = grupoId;
        this.devedorId = devedorId;
        this.credorId = credorId;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public UUID getId() {
        return id;
    }

    public UUID getViagemId() {
        return grupoId;
    }

    public UUID getDevedorId() {
        return devedorId;
    }

    public UUID getCredorId() {
        return credorId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
