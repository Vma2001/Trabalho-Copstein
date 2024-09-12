package com.bcopstein.ex1biblioeca;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private Record record;

    public Controller(Record record1) {this.record = record1;}

    public Controller(){}

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getListaLivros() {
        return record.getLivros();
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

    @PostMapping("")
    @CrossOrigin(origins = "*")
    public String adicionarLivro(@RequestParam Livro livro) {
        return record.addLivro(livro);
    }
}