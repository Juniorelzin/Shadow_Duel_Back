package com.shadowcard.demo.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "usuarios")
@Entity
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    // @Column(name = "nome")
    // private String nome;

    @Column(name = "username", nullable = false)
    private String fullName;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false, name="senha")
    private String password;

     @Column(name = "dinheiro")
    private Integer dinheiro = 100;

    @ManyToMany
    @JoinTable(
        name = "deck_usuarios", 
        joinColumns = @JoinColumn(name = "id_usuarios"), 
        inverseJoinColumns = @JoinColumn(name = "id_decks")
    )

    private List<DeckEntity> decks; // Renomear para decks no plural

    // @CreationTimestamp
    // @Column(updatable = false, name = "created_at")
    // private Date createdAt;

    // @UpdateTimestamp
    // @Column(name = "updated_at")
    // private Date updatedAt;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "role_id")
    // private RoleEntity role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public List<DeckEntity> getDecks() {
        return decks;
    }

    public void setDecks(List<DeckEntity> decks) {
        this.decks = decks;
    }

    // public String getNome() {
    //     return nome;
    // }

    // public void setNome(String nome) {
    //     this.nome = nome;
    // }
    



    // public Date getCreatedAt() {
    // return createdAt;
    // }

    // public void setCreatedAt(Date createdAt) {
    // this.createdAt = createdAt;
    // }

    // public Date getUpdatedAt() {
    // return updatedAt;
    // }

    // public void setUpdatedAt(Date updatedAt) {
    // this.updatedAt = updatedAt;
    // }
}
