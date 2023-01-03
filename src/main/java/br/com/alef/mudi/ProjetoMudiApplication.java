package br.com.alef.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ProjetoMudiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoMudiApplication.class, args);
	}

}
