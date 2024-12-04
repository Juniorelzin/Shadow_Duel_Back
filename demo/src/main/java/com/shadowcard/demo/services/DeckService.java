package com.shadowcard.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadowcard.demo.dtos.req.CreateDeckDTO;

import com.shadowcard.demo.dtos.res.ShowDeckDTO;

import com.shadowcard.demo.entities.DeckEntity;

import com.shadowcard.demo.repositories.DeckRepository;



@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;


    
    public void createDeck(CreateDeckDTO dto) {

      
        DeckEntity deckEntity = new DeckEntity();
        deckEntity.setTipo(dto.getTipo());
        deckEntity = deckRepository.save(deckEntity);

    
    }


    public List<ShowDeckDTO> getDecks() {
        List<DeckEntity> deckEntity = deckRepository.findAll();

        return deckEntity.stream().map(deck -> {
            ShowDeckDTO deckDTO = new ShowDeckDTO();
                
            
            deckDTO.setId(deck.getId());
            deckDTO.setTipo(deck.getTipo());
          

            return deckDTO;
        }).toList();
    }
}

