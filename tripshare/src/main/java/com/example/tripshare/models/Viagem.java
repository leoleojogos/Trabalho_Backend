package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Viagem {
    private UUID id;
    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private int moeda;  // chave estrangeira futura
    private UUID criadorId; // chave estrangeira futura

    public Viagem(UUID id, String nome, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim, int moeda, UUID criadorId) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.moeda = moeda;
        this.criadorId = criadorId;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public int getMoeda() {
        return moeda;
    }

    public void setMoeda(int moeda) {
        this.moeda = moeda;
    }

    public UUID getCriadorId() {
        return criadorId;
    }
}
