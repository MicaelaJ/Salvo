package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}
//clase sin constructor bean
	@Bean
	public CommandLineRunner initData (PlayerRepository playerRepository,
									   GameRepository gameRepository,
									   GamePlayerRepository gamePlayerRepository) {
		return (args) ->{
			//guarda jugadores de prueba
			Player p1 = new Player ("j.bauer@ctu.gov");
			Player p2 = new Player ("c.obrian@ctu.gov");
			Player p3 = new Player ("kim.bauer@gmail.com");
			Player p4 = new Player ("t.ailmeida@ctu.gov");
			playerRepository.saveAll (Arrays.asList(p1,p2,p3,p4));

			Date date = new Date();

			Game g1 = new Game (date);
			Game g2 = new Game (Date.from(date.toInstant().plusSeconds(3600))); //suma 1 hora mas
			Game g3 = new Game(Date.from(date.toInstant().plusSeconds(7200))); //suma 2 horas ma// s
			Game g4 = new Game(Date.from(date.toInstant().plusSeconds(7200)));
			Game g5 = new Game(Date.from(date.toInstant().plusSeconds(7200)));
			Game g6 = new Game(Date.from(date.toInstant().plusSeconds(7200)));

			gameRepository.saveAll(Arrays.asList(g1,g2,g3,g4,g5,g6));

			GamePlayer gp1 = new GamePlayer(g1, p1);
			GamePlayer gp2 = new GamePlayer(g1, p2);
			GamePlayer gp3 = new GamePlayer(g2, p1);
			GamePlayer gp4 = new GamePlayer(g2, p2);
			GamePlayer gp5 = new GamePlayer(g3, p2);
			GamePlayer gp6 = new GamePlayer(g3, p4);
			GamePlayer gp7 = new GamePlayer(g4, p2);
			GamePlayer gp8 = new GamePlayer(g4, p1);
			GamePlayer gp9 = new GamePlayer(g5, p4);
			GamePlayer gp10 = new GamePlayer(g5, p1);
			GamePlayer gp11 = new GamePlayer(g6, p3);
			GamePlayer gp12 = new GamePlayer(g5, p4);
			GamePlayer gp13 = new GamePlayer(g5, p3);
			GamePlayer gp14 = new GamePlayer(g5, p4);

			gamePlayerRepository.saveAll(Arrays.asList(gp1, gp2, gp3, gp4, gp5, gp6, gp7, gp8, gp9, gp10, gp11, gp12, gp13, gp14));
		};
	}
}
