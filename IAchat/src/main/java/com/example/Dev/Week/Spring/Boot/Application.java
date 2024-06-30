package com.example.Dev.Week.Spring.Boot;

import com.example.Dev.Week.Spring.Boot.application.AskChampionUseCase;
import com.example.Dev.Week.Spring.Boot.application.ListChampionsUseCase;
import com.example.Dev.Week.Spring.Boot.domain.ports.ChampionsRepository;
import com.example.Dev.Week.Spring.Boot.domain.ports.GenerativeAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ListChampionsUseCase providelistChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCase(repository);
	}

	@Bean
	public AskChampionUseCase provideAskChampionsUseCase(ChampionsRepository repository, GenerativeAiService genAiService){
		return new AskChampionUseCase(repository,genAiService);
	}
}
