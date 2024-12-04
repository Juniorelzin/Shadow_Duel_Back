package com.shadowcard.demo.dtos.req;

import java.util.List;

public class CreateUsuarioDTO {
    private String fullName;
    private String email;
    private String password;
    private List<Long> decks; // Lista de IDs dos decks

    // Getters e Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getDecks() {
        return decks;
    }

    public void setDecks(List<Long> decks) {
        this.decks = decks;
    }
}
