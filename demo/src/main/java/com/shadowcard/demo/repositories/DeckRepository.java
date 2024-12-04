package com.shadowcard.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowcard.demo.entities.DeckEntity;
import java.util.List;


public interface DeckRepository extends JpaRepository<DeckEntity, Long> {
    List<DeckEntity> findAllById(Iterable<Long> ids);
}
