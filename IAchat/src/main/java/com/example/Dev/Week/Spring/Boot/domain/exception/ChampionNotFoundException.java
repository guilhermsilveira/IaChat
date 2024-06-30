package com.example.Dev.Week.Spring.Boot.domain.exception;

public class ChampionNotFoundException extends RuntimeException{

    public ChampionNotFoundException(long championId){
        super("Champion %d not found.".formatted(championId));
    }
}
