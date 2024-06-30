package com.example.Dev.Week.Spring.Boot.application;

import com.example.Dev.Week.Spring.Boot.domain.exception.ChampionNotFoundException;
import com.example.Dev.Week.Spring.Boot.domain.model.Champions;
import com.example.Dev.Week.Spring.Boot.domain.ports.ChampionsRepository;
public record AskChampionUseCase(ChampionsRepository repository, com.example.Dev.Week.Spring.Boot.domain.ports.GenerativeAiService genAiService) {

    public String  askChampion(Long championId, String question){

        Champions champion = repository.findById(championId).orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);

        String objective = """
                Atue como um assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL).
                Responsa perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, o nome do Campeão e sua respectiva lore (história):
                
                """;
        return genAiService.generateContent(objective, context);
    }
}
