package com.shadowcard.demo.dtos.res;

import java.util.List;

public class ShowUsuarioDTO {
    private long id;
    private String fullName;
    private String email;
    private int dinheiro;
    private List<Long> decks; // Lista de IDs dos decks

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public List<Long> getDecks() {
        return decks;
    }

    public void setDecks(List<Long> decks) {
        this.decks = decks;
    }
}
