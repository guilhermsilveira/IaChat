package com.example.Dev.Week.Spring.Boot.application;

import com.example.Dev.Week.Spring.Boot.domain.model.Champions;
import com.example.Dev.Week.Spring.Boot.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {

        public List<Champions> findAll(){return repository.findAll();}
}

