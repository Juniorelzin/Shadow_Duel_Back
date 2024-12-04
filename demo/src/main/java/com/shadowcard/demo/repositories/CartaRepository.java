package com.shadowcard.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowcard.demo.entities.CartaEntity;


public interface CartaRepository extends JpaRepository<CartaEntity, Long>  {
    
}

