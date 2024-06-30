package com.example.Dev.Week.Spring.Boot.adapters.in;

import com.example.Dev.Week.Spring.Boot.application.AskChampionUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/champions")
public record AskChampionsRestController (AskChampionUseCase useCase) {

    @CrossOrigin
    @PostMapping("/{championId}/ask")
    public AskChampionResponse AskChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request) {

        String answer = useCase.askChampion(championId, request.question());

        return  new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question) {}
    public record AskChampionResponse(String answer) {}

}


