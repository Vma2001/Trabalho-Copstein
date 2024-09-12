package com.bcopstein.ex1biblioeca;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Record {
    private int cod = 5001;
private JdbcTemplate jdbcTemplate;
    public Record(JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate = jdbcTemplate1;
    }

    public List<Livro> getLivros() {
//        List<Livro> livros = jdbcTemplate.
        return null;
    }

    public String addLivro(Livro livro) {
        try{
                jdbcTemplate.update(
                "Insert into (codigo, titulo, autor, ano) values (?, ?, ?, ?)",
                livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAno()
        );}catch(Exception e){return "Deu problema";}
        return "Deu bom";
    }

    //public boolean add(Livro livro){return livros.add(livro);}
}
