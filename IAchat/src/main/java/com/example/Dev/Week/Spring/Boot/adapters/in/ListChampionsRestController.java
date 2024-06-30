package com.example.Dev.Week.Spring.Boot.adapters.in;

import com.example.Dev.Week.Spring.Boot.application.ListChampionsUseCase;
import com.example.Dev.Week.Spring.Boot.domain.model.Champions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {

    @GetMapping
    public List<Champions> findAllChampions(){
        return useCase.findAll();
    }
}
