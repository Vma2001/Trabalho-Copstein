package com.bcopstein.ex1biblioeca;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private Record record;
@Autowired
    public Controller(Record record) {this.record = record;}

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("/livros")
    @CrossOrigin(origins = "*")
    public List<livros> getListaLivros() {
        return this.record.getLivros();
    }

    @GetMapping("autores")
    @CrossOrigin(origins = "*")
    public List<String> getListaAutores() {
        List<livros>livros  = record.getLivros();
        return livros.stream()
                .map(l -> l.getAutor())
                .distinct()
                .toList();
    }

    @GetMapping("titulos")
    @CrossOrigin(origins = "*")
    public List<String> getListaTitulos() {
        List<livros>livros  = record.getLivros();
        return livros.stream()
                .map(l -> l.getTitulo())
                .toList();
    }

    @GetMapping("PorAno")
    @CrossOrigin(origins = "*")
    public List<livros> getLivrosPorAno(@RequestParam int ano) {
        List<livros>livros  = record.getLivros();
        List<com.bcopstein.ex1biblioeca.livros> livrosAno = new LinkedList<>();

        for (com.bcopstein.ex1biblioeca.livros l : livros) {
            if (l.getAno() == ano) {
                livrosAno.add(l);
            }
        }
        return livrosAno;
    }
}