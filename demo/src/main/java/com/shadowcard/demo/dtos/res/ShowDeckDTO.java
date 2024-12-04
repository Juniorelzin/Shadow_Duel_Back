
package com.shadowcard.demo.dtos.res;

import java.util.List;

public class ShowDeckDTO {
    private long id;
    private String tipo;
    private List<Long> cartas; // Lista de IDs das cartas
    private List<Long> usuarios; // Lista de IDs dos usuários

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
