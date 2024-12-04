package com.shadowcard.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadowcard.demo.dtos.req.CreateUsuarioDTO;

import com.shadowcard.demo.dtos.res.ShowUsuarioDTO;
import com.shadowcard.demo.dtos.req.CreateAddDeckUsuario;
import com.shadowcard.demo.entities.DeckEntity;
import com.shadowcard.demo.entities.UserEntity;

import com.shadowcard.demo.repositories.UserRepository;
import com.shadowcard.demo.repositories.DeckRepository;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private DeckRepository deckRepository;

    public void createUsuario(CreateUsuarioDTO dto) {

        UserEntity usuarioEntity = new UserEntity();
        usuarioEntity.setFullName(dto.getFullName());
        usuarioEntity.setEmail(dto.getEmail());
        usuarioEntity.setPassword(dto.getPassword());
        usuarioEntity = usuarioRepository.save(usuarioEntity);

    }

    public List<ShowUsuarioDTO> getUsuarios() {
        List<UserEntity> usuarioEntity = usuarioRepository.findAll();

        return usuarioEntity.stream().map(usuario -> {
            ShowUsuarioDTO usuarioDTO = new ShowUsuarioDTO();

            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setFullName(usuario.getFullName());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setDinheiro(usuario.getDinheiro());
            usuarioDTO.setDecks(usuario.getDecks().stream().map(deck -> deck.getId()).toList());

            return usuarioDTO;
        }).toList();
    }

    public void addDecksToUsuario(CreateAddDeckUsuario dto) {
        UserEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<DeckEntity> decks = deckRepository.findAllById(dto.getDeckIds());

        usuario.getDecks().addAll(decks);
        usuarioRepository.save(usuario);
    }

    public void buyDecksUsuario(CreateAddDeckUsuario dto) {
        UserEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<DeckEntity> decks = deckRepository.findAllById(dto.getDeckIds());

        // Calcular o custo total dos decks
        int totalCusto = decks.stream()
        .mapToInt(DeckEntity::getPreco)
        .sum();

        // Verificar se o usuário tem dinheiro suficiente
        if (usuario.getDinheiro() < totalCusto) {
            throw new RuntimeException("Dinheiro insuficiente para comprar os decks.");
        }

        // Filtrar decks que o usuário já possui
        List<DeckEntity> decksParaAdicionar = decks.stream()
                .filter(deck -> !usuario.getDecks().contains(deck))
                .collect(Collectors.toList());

        // Verificar se há decks duplicados
        if (decksParaAdicionar.isEmpty()) {
            throw new RuntimeException("Você já possui todos os decks selecionados.");
        }

        // Adicionar os decks ao usuário
        usuario.getDecks().addAll(decksParaAdicionar);

        // Diminuir o dinheiro do usuário
        usuario.setDinheiro(usuario.getDinheiro() - totalCusto);

        usuarioRepository.save(usuario);
    }

}
