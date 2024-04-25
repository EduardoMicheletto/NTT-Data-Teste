package com.br.ntt.service;

import com.br.ntt.holder.FilmHolder;
import com.br.ntt.model.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmsService {
    public void alterar(Filme filme) throws Exception {
//        valida se filme existe por id
        if(FilmHolder.getInstance().stream().noneMatch(filmFilter -> filmFilter.getEpisode_id() == filme.getEpisode_id())){
            throw new Exception("Id não existe.");
        }
        if(!filme.isValid()){
            throw new Exception("Filme está com campos nulos ou vazios.");
        }

        List<Filme> filmes = FilmHolder.getInstance();
        for (int i = 0; i < filmes.size(); i++) {
            if(filmes.get(i).getEpisode_id() == filme.getEpisode_id()){
                int versao = filmes.get(i).getVersao();
                filmes.set(i, filme);
                filmes.get(i).setVersao(versao + 1);
                break;
            }
        }
    }

    public List<Filme> listarFilmes() {
        return FilmHolder.getInstance();
    }

    public Filme getFilme(int id) {
        return FilmHolder.getInstance().stream().filter(film -> film.getEpisode_id() == id).findFirst().orElse(null);
    }

    public void criar(Filme filme) throws Exception {
        if(FilmHolder.getInstance().stream().anyMatch(filmFilter -> filmFilter.getEpisode_id() == filme.getEpisode_id())){
            throw new Exception("Id existe.");
        }
        if(!filme.isValid()){
            throw new Exception("Filme está com campos nulos ou vazios.");
        }
        filme.setVersao(1);
        FilmHolder.getInstance().add(filme);
    }
}
