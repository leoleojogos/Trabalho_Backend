package com.example.tripshare.models;

import java.util.UUID;

public class DivisaoDespesa {
    private UUID id;
    private UUID despesaId;
    private UUID participanteId;
    private double valorDevido;

    public DivisaoDespesa(UUID id, UUID despesaId, UUID participanteId, double valorDevido) {
        this.id = id;
        this.despesaId = despesaId;
        this.participanteId = participanteId;
        this.valorDevido = valorDevido;
    }

    public UUID getId() {
        return id;
    }

    public UUID getDespesaId() {
        return despesaId;
    }

    public UUID getParticipanteId() {
        return participanteId;
    }

    public double getValorDevido() {
        return valorDevido;
    }

    public void setValorDevido(double valorDevido) {
        this.valorDevido = valorDevido;
    }
}
