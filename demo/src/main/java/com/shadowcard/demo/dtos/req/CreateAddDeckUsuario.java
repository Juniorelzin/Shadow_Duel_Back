package com.shadowcard.demo.dtos.req;

import java.util.List;

public class CreateAddDeckUsuario  {
    private Long usuarioId;
    private List<Long> deckIds;

    // Getters e Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Long> getDeckIds() {
        return deckIds;
    }

    public void setDeckIds(List<Long> deckIds) {
        this.deckIds = deckIds;
    }
}