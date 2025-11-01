package com.example.tripshare.models;

import java.util.UUID;

public class ParticipanteAcordo {
    private UUID acordoId;
    private UUID usuarioId;
    private double valorPago;
    private double valorDevido;

    public ParticipanteAcordo(UUID acordoId, UUID usuarioId, double valorPago, double valorDevido) {
        this.acordoId = acordoId;
        this.usuarioId = usuarioId;
        this.valorPago = valorPago;
        this.valorDevido = valorDevido;
    }

    public UUID getAcordoId() {
        return acordoId;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorDevido() {
        return valorDevido;
    }

    public void setValorDevido(double valorDevido) {
        this.valorDevido = valorDevido;
    }
}
