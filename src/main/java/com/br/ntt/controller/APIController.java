package com.br.ntt.controller;

import com.br.ntt.model.Filme;
import com.br.ntt.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filme")
public class APIController {

    @Autowired
    private FilmsService service;

//    Criar um endpoint onde é possível alterar a descrição de um filme em memória;
    @PutMapping("")
    public ResponseEntity<HttpStatus> alterarDescricao(@RequestBody Filme filme) {
        try {
            service.alterar(filme);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

//    Criar um endpoint onde é possível listar os filmes da saga;
    @GetMapping()
    public ResponseEntity<List<Filme>> listarFilmes(){
        return new ResponseEntity<>(service.listarFilmes(), HttpStatus.OK);
    }


//    Criar um endpoint onde é possível exibir detalhes de um filme;
    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilme(@PathVariable int id){
        Filme filme = service.getFilme(id);
        if(filme != null){
            return new ResponseEntity<>(filme, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Criar um endpoint onde é possível detalhar um filme especifico;








}
