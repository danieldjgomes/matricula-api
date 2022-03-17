package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO")
@ComponentScan("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi")
@EntityScan("br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO")
public class MatriculaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatriculaApiApplication.class, args);
    }

}
