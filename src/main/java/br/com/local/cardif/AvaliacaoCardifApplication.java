package br.com.local.cardif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaAuditing
@ComponentScan(basePackages="br.com.local.cardif")
public class AvaliacaoCardifApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoCardifApplication.class, args);
	}

}
