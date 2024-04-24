package com.br.ntt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class FilmResponse {
    private int count;
    private String next;
    private String previous;
    private List<Filme> results;
    
}
