package com.shadowcard.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadowcard.demo.dtos.req.CreateDeckDTO;
import com.shadowcard.demo.dtos.res.ShowDeckDTO;
import com.shadowcard.demo.services.DeckService;

@RestController
@RequestMapping("/decks")
public class DeckController {
    
    @Autowired
    private DeckService deckService;

    @PostMapping
    public ResponseEntity<?> createDeck(@RequestBody CreateDeckDTO dto) {
      
        deckService.createDeck(dto);
     
        return ResponseEntity.status(201).build();
    }

   
    @GetMapping
    public ResponseEntity<List<ShowDeckDTO>> getAllDeck() {
       
        List<ShowDeckDTO> decks = deckService.getDecks();
      
        return ResponseEntity.ok(decks);
    }
}
