package com.bcopstein.ex1biblioeca;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Record {
private JdbcTemplate jdbcTemplate;
    public Record(JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate = jdbcTemplate1;
    }

    public List<Livro> getLivros() {
        List<Livro> livros = jdbcTemplate.

    }

    public boolean add(Livro livro){return livros.add(livro);}
}
