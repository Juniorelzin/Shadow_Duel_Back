package com.shadowcard.demo.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "cartas") // Nome da tabela em plural
public class CartaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "ataque")
    private Integer ataque;

    @Column(name = "defesa")
    private Integer defesa;

    @Column(name = "local_imagem")
    private String localImagem;

    @ManyToMany
    @JoinTable(
        name = "deck_cartas", 
        joinColumns = @JoinColumn(name = "id_cartas"), 
        inverseJoinColumns = @JoinColumn(name = "id_decks")
    )
    private List<DeckEntity> decks; // Renomear para decks no plural

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public String getLocalImagem() {
        return localImagem;
    }

    public void setLocalImagem(String localImagem) {
        this.localImagem = localImagem;
    }

    public List<DeckEntity> getDecks() {
        return decks;
    }

    public void setDecks(List<DeckEntity> decks) {
        this.decks = decks;
    }
}
