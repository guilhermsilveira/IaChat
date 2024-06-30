package com.example.Dev.Week.Spring.Boot.domain.ports;

import com.example.Dev.Week.Spring.Boot.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    List<Champions> findAll();

    Optional<Champions> findById(Long id);
}
