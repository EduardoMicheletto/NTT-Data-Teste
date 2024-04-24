package com.br.ntt.service;

import com.br.ntt.model.FilmResponse;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.*;


@Service
public class StarWarsService {

    private static final String SWAPI_BASE_URL = "https://swapi.dev/api";

    public WebClient createWebClient() {
        HttpClient httpClient = HttpClient.create()
                .secure(sslContextSpec -> {
                    try {
                        sslContextSpec.sslContext(
                                SslContextBuilder.forClient()
                                        .trustManager(InsecureTrustManagerFactory.INSTANCE)
                                        .build()
                        );
                    } catch (SSLException e) {
                        throw new RuntimeException(e);
                    }
                });

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }


    public FilmResponse getFilms() {
        WebClient  builder = createWebClient();

        FilmResponse response = builder
                .get()
                .uri(SWAPI_BASE_URL + "/films")
                .retrieve()
                .bodyToMono(FilmResponse.class)
                .block();

        return response;
    }

}
