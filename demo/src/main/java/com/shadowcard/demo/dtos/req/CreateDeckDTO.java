package com.shadowcard.demo.dtos.req;

import java.util.List;

public class CreateDeckDTO {
    private String tipo;
    private List<Long> cartas; // Lista de IDs das cartas
    private List<Long> usuarios; // Lista de IDs dos usuários

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Long> getCartas() {
        return cartas;
    }

    public void setCartas(List<Long> cartas) {
        this.cartas = cartas;
    }

    public List<Long> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Long> usuarios) {
        this.usuarios = usuarios;
    }
}
