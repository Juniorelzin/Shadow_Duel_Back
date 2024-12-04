package com.shadowcard.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadowcard.demo.dtos.req.CreateCartaDTO;
import com.shadowcard.demo.dtos.res.ShowCartaDTO;
import com.shadowcard.demo.services.CartaService;

@RestController
@RequestMapping("/cartas")
public class CartaController {
    
    @Autowired
    private CartaService cartaService;

     @PostMapping
    public ResponseEntity<?> createCarta(@RequestBody CreateCartaDTO dto) {
      
        cartaService.createCarta(dto);
     
        return ResponseEntity.status(201).build();
    }

   
    @GetMapping
    public ResponseEntity<List<ShowCartaDTO>> getAllCartas() {
       
        List<ShowCartaDTO> cartas = cartaService.getCartas();
      
        return ResponseEntity.ok(cartas);
    }

}    