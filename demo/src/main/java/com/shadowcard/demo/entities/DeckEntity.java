package com.shadowcard.demo.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "decks") // Nome da tabela em plural
public class DeckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "preco")
    private Integer preco;

    @ManyToMany
    @JoinTable(
        name = "deck_cartas", 
        joinColumns = @JoinColumn(name = "id_decks"), 
        inverseJoinColumns = @JoinColumn(name = "id_cartas")
    )
    private List<CartaEntity> cartas; // Renomear para cartas

    @ManyToMany
    @JoinTable(
        name = "deck_usuarios", 
        joinColumns = @JoinColumn(name = "id_decks"), 
        inverseJoinColumns = @JoinColumn(name = "id_usuarios")
    )
    private List<UserEntity> usuarios; // Renomear para usuarios

    // Getters e Setters
    public long getId() {
        return id;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
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

    public List<CartaEntity> getCartas() {
        return cartas;
    }

    public void setCartas(List<CartaEntity> cartas) {
        this.cartas = cartas;
    }

    public List<UserEntity> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UserEntity> usuarios) {
        this.usuarios = usuarios;
    }
}
