package com.example.tripshare.models;

import java.util.UUID;

public class MembroGrupo {
    private UUID usuarioId;
    private UUID grupoId;
    private boolean isadmin;

    public MembroGrupo(UUID usuarioId, UUID grupoId, boolean isadmin) {
        this.usuarioId = usuarioId;
        this.grupoId = grupoId;
        this.isadmin = isadmin;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public UUID getGrupoId() {
        return grupoId;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
}
