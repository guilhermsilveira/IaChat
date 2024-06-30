package com.example.Dev.Week.Spring.Boot.domain.model;

public record Champions(
        Long id,
        String name,
        String role,
        String lore,
        String imageUrl
) {
    public String generateContextByQuestion(String question){
        return """
               Pergunta: %s
               Nome do campeão: %s
               Função: %s
               História: %s
               """.formatted(question,this.name, this.role, this.lore);
    }
}
