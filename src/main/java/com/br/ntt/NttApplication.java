package com.br.ntt;

import com.br.ntt.holder.FilmHolder;
import com.br.ntt.service.StarWarsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class NttApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        SpringApplication.run(NttApplication.class, args);

        StarWarsService starWarsService = new StarWarsService();
        FilmHolder.setFilmResponse(starWarsService.getFilms().getResults());
    }

}
