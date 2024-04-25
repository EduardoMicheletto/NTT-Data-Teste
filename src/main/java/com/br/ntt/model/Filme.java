package com.br.ntt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Filme {
    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;
    private String url;
    private int versao = 1;

    public boolean isValid() {
        return !isEmpty(title)
                && episode_id > 0
                && !isEmpty(opening_crawl)
                && !isEmpty(director)
                && !isEmpty(producer)
                && !isEmpty(release_date)
                && characters != null //&& !characters.isEmpty()
                && planets != null //&& !planets.isEmpty()
                && starships != null //&& !starships.isEmpty()
                && vehicles != null// && !vehicles.isEmpty()
                && species != null //&& !species.isEmpty()
                && !isEmpty(created)
                && !isEmpty(edited)
                && !isEmpty(url);
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    
}
