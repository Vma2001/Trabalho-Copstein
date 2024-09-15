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

    @GetMapping("/usuarios")
    @CrossOrigin(origins = "*")
    public List<Usuario> getListaUsuarios() {return this.record.getUsuarios();}

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

    @GetMapping("/livros/disponiveis")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDisponiveis() {
        return record.getLivrosDisponiveis();
    }

    @GetMapping("/livros/emprestados/{codigoUsuario}")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosEmprestadosPorUsuario(@PathVariable int codigoUsuario) {
        return record.getLivrosEmprestadosPorUsuario(codigoUsuario);
    }

    @PostMapping("/livros/{id}/retirar")
    @CrossOrigin(origins = "*")
    public String retirarLivro(@PathVariable int id, @RequestParam int codigoUsuario) {
        Livro livro = record.getLivroPorId(id);
        if (livro.getCodigoUsuario() == -1) {
            record.atualizarCodigoUsuarioLivro(id, codigoUsuario);
            return "Livro retirado com sucesso!";
        } else {
            return "O livro já está emprestado.";
        }
    }

    @PostMapping("/livros/{codigo}/devolver")
    @CrossOrigin(origins = "*")
    public String devolverLivro(@PathVariable int codigo, @RequestParam int codigoUsuario) {
        Livro livro = record.getLivroPorId(codigo);
        if (livro.getCodigoUsuario() == codigoUsuario) {
            record.atualizarCodigoUsuarioLivro(codigo, -1);
            return "Livro devolvido com sucesso!";
        } else {
            return "Este livro não foi retirado por esse usuário.";
        }
    }

    @PostMapping("/usuarios")
    @CrossOrigin(origins = "*")
    public String cadastrarUsuario(@RequestBody Usuario usuario) {
        record.cadastrarUsuario(usuario);
        return "Usuário cadastrado com sucesso!";
    }
}