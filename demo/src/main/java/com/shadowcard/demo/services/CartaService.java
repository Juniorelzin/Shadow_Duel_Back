package com.shadowcard.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadowcard.demo.dtos.req.CreateCartaDTO;

import com.shadowcard.demo.dtos.res.ShowCartaDTO;

import com.shadowcard.demo.entities.CartaEntity;

import com.shadowcard.demo.repositories.CartaRepository;


@Service
public class CartaService {


    @Autowired
    private CartaRepository cartaRepository;

    public void createCarta(CreateCartaDTO dto) {
   
        CartaEntity cartaEntity = new CartaEntity();
        cartaEntity.setNome(dto.getNome());
        cartaEntity.setNumero(dto.getNumero());
        cartaEntity.setAtaque(dto.getAtaque());
        cartaEntity.setDefesa(dto.getDefesa());
        cartaEntity.setLocalImagem(dto.getLocalImagem());
        
        cartaEntity = cartaRepository.save(cartaEntity);

    
    }


    public List<ShowCartaDTO> getCartas() {
        List<CartaEntity> cartaEntity = cartaRepository.findAll();

        return cartaEntity.stream().map(carta -> {
            ShowCartaDTO cartaDTO = new ShowCartaDTO();
                
            
            cartaDTO.setId(carta.getId());
            cartaDTO.setNome(carta.getNome());
            cartaDTO.setNumero(carta.getNumero());
            cartaDTO.setAtaque(carta.getAtaque());
            cartaDTO.setDefesa(carta.getDefesa());
            cartaDTO.setLocalImagem(carta.getLocalImagem());
           

            return cartaDTO;
        }).toList();
    }
}