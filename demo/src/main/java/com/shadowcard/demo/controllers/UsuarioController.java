package com.shadowcard.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadowcard.demo.dtos.req.CreateAddDeckUsuario;
import com.shadowcard.demo.dtos.req.CreateUsuarioDTO;
import com.shadowcard.demo.dtos.res.ShowUsuarioDTO;
import com.shadowcard.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody CreateUsuarioDTO dto) {
      
        usuarioService.createUsuario(dto);
     
        return ResponseEntity.status(201).build();
    }

   
    @GetMapping
    public ResponseEntity<List<ShowUsuarioDTO>> getAllUsuarios() {
       
        List<ShowUsuarioDTO> usuarios = usuarioService.getUsuarios();
      
        return ResponseEntity.ok(usuarios);
    }

        @PutMapping("/add-decks")
        public ResponseEntity<?> addDecksToUsuario(@RequestBody CreateAddDeckUsuario dto) {
        usuarioService.addDecksToUsuario(dto);
        return ResponseEntity.status(200).build();
    }

        @PutMapping("/buy-decks")
        public ResponseEntity<?> buyDecksToUsuario(@RequestBody CreateAddDeckUsuario dto) {
        usuarioService.buyDecksUsuario(dto);
        return ResponseEntity.status(200).build();
}
}
