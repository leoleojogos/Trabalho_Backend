package com.example.tripshare.models;

import java.util.UUID;

public class TransacaoSugerida {
    private UUID id;
    private UUID viagemId;
    private UUID devedorId;
    private UUID credorId;
    private double valor;

    public TransacaoSugerida(UUID id, UUID viagemId, UUID devedorId, UUID credorId, double valor) {
        this.id = id;
        this.viagemId = viagemId;
        this.devedorId = devedorId;
        this.credorId = credorId;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public UUID getViagemId() {
        return viagemId;
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
}
