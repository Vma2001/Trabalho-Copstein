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
    public List<Livro> getListaLivros() {
        return this.record.getLivros();
    }

    @GetMapping("autores")
    @CrossOrigin(origins = "*")
    public List<String> getListaAutores() {
        List<Livro>livros  = record.getLivros();
        return livros.stream()
                .map(l -> l.getAutor())
                .distinct()
                .toList();
    }

    @GetMapping("titulos")
    @CrossOrigin(origins = "*")
    public List<String> getListaTitulos() {
        List<Livro>livros  = record.getLivros();
        return livros.stream()
                .map(l -> l.getTitulo())
                .toList();
    }

    @GetMapping("PorAno")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosPorAno(@RequestParam int ano) {
        List<Livro>livros  = record.getLivros();
        List<Livro> livrosAno = new LinkedList<>();

        for (Livro l : livros) {
            if (l.getAno() == ano) {
                livrosAno.add(l);
            }
        }
        return livrosAno;
    }
}