package com.example.tripshare.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Despesa {
    private UUID id;
    private UUID viagemId;
    private String descricao;
    private LocalDateTime data;
    private UUID pagadorId;
    private int categoria;  // futura chave estrangeira

    public Despesa(UUID id, UUID viagemId, String descricao, LocalDateTime data, UUID pagadorId, int categoria) {
        this.id = UUID.randomUUID();
        this.viagemId = viagemId;
        this.descricao = descricao;
        this.data = LocalDateTime.now();
        this.pagadorId = pagadorId;
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }

    public UUID getViagemId() {
        return viagemId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public UUID getPagadorId() {
        return pagadorId;
    }

    public void setPagadorId(UUID pagadorId) {
        this.pagadorId = pagadorId;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
