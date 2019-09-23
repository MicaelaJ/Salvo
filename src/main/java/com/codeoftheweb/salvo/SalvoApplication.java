package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Arrays;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}
//clase sin constructor bean
	@Bean
	public CommandLineRunner initData (PlayerRepository playerRepository) {
		return (args) ->{
			//guarda jugadores de prueba
			Player p1 = new Player ("j.bauer@ctu.gov");
			Player p2 = new Player ("c.obrian@ctu.gov");
			Player p3 = new Player ("kim.bauer@gmail.com");
			Player p4 = new Player ("t.ailmeida@ctu.gov");
			playerRepository.saveAll (Arrays.asList(p1,p2,p3,p4));
		};
	}
}
