package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Participante extends Usuario {
    private String apelidoNoGrupo;
    private double saldoAtual;

    public Participante(UUID id, String nome, String email, LocalDateTime dataCriacao, String apelidoNoGrupo, double saldoAtual) {
        super(id, nome, email, dataCriacao);
        this.apelidoNoGrupo = apelidoNoGrupo;
        this.saldoAtual = saldoAtual;
    }

    public String getApelidoNoGrupo() {
        return apelidoNoGrupo;
    }

    public void setApelidoNoGrupo(String apelidoNoGrupo) {
        this.apelidoNoGrupo = apelidoNoGrupo;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
}
