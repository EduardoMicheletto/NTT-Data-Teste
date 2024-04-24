package com.br.ntt.holder;

import com.br.ntt.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmHolder {

    // Instância única da classe FilmResponse
    private static List<Filme> filmeInstance;

    // Construtor privado para evitar a criação de instâncias da classe
    private FilmHolder() {
    }

    // Método para obter a instância única de FilmResponse
    public static List<Filme> getInstance() {
        if (filmeInstance == null) {
            filmeInstance = new ArrayList<>();
        }
        return filmeInstance;
    }

    // Método para definir o objeto FilmResponse
    public static void setFilmResponse(List<Filme> filme) {
        filmeInstance = filme;
    }
}

