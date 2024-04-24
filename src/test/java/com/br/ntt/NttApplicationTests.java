package com.br.ntt;

import com.br.ntt.holder.FilmHolder;
import com.br.ntt.model.Filme;
import com.br.ntt.model.FilmResponse;
import com.br.ntt.service.FilmsService;
import com.br.ntt.service.StarWarsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class NttApplicationTests {

    @Mock
    private StarWarsService starWarsService;

    @Mock
    private FilmsService filmsServiceMock;

    @Autowired
    private FilmsService filmsService;

    @Test
    void contextLoads() {
    }

    @Test
    void testStarWarsService() {
        when(starWarsService.getFilms()).thenReturn(new FilmResponse());
    }

    @Test
    void testGetFilmReturnFilme() {
        when(filmsServiceMock.getFilme(1)).thenReturn(new Filme());
    }


    @Test
    void testGetFilmReturnListFilme() {
        when(filmsServiceMock.listarFilmes()).thenReturn(new ArrayList<>());
    }

    @Test
    void testPutFilmReturnOK() throws Exception {
        Filme filmeInicial = Filme.builder()
                .characters(new ArrayList<>())
                .director("Diretor Antigo")
                .planets(new ArrayList<>())
                .title("Título Antigo")
                .url("URL Antiga")
                .edited("Editado Antigo")
                .episode_id(1)
                .opening_crawl("Opening Crawl Antigo")
                .producer("Produtor Antigo")
                .release_date("Data Antiga")
                .species(new ArrayList<>())
                .starships(new ArrayList<>())
                .created("Criado Antigo")
                .vehicles(new ArrayList<>())
                .versao(1)
                .build();

        FilmHolder.getInstance().add(filmeInicial);

        // Filme atualizado
        Filme filmeAtualizado = Filme.builder()
                .characters(new ArrayList<>())
                .director("Novo Diretor")
                .planets(new ArrayList<>())
                .title("Novo Título")
                .url("Nova URL")
                .edited("Novo Editado")
                .episode_id(1)
                .opening_crawl("Novo Opening Crawl")
                .producer("Novo Produtor")
                .release_date("Nova Data")
                .species(new ArrayList<>())
                .starships(new ArrayList<>())
                .created("Novo Criado")
                .vehicles(new ArrayList<>())
                .versao(2) // Versão incrementada
                .build();

        filmsService.alterar(filmeAtualizado);

        // Verificando se o método alterar foi chamado corretamente
        List<Filme> filmes = FilmHolder.getInstance();
        // Verificando se o filme foi atualizado corretamente
        Filme filmeAtualizadoNoHolder = FilmHolder.getInstance().stream()
                .filter(f -> f.getEpisode_id() == filmeAtualizado.getEpisode_id())
                .findFirst()
                .orElse(null);

        assertNotNull(filmeAtualizadoNoHolder);
        assertEquals(filmeAtualizado, filmeAtualizadoNoHolder);
    }



}
