package com.GrupoAlvaro.SistemaGuardias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SistemaGuardiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaGuardiasApplication.class, args);
	}

}
