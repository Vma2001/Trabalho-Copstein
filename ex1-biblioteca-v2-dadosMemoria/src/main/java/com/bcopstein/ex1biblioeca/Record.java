package com.bcopstein.ex1biblioeca;

import java.sql.JDBCType;
import java.util.LinkedList;
import java.util.List;

public class Record {
    private List<Livro> livros;

    public Record(Jd) {
        livros = new LinkedList<>();
        livros.add(new Livro(100, "Aprendendo Spring-Boot", "Huguinho Pato", 2020));
        livros.add(new Livro(120, "Aprendendo Java", "Zezinho Pato", 2015));
        livros.add(new Livro(140, "Aprendendo Outra coisa", "Luizinho Pato", 2023));
        livros.add(new Livro(140, "Aprendendo Uma coisa nova", "Huguinho Pato", 2023));
        livros.add(new Livro(140, "Aprendendo Outra coisa nova", "Huguinho Pato", 2023));
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public boolean add(Livro livro){return livros.add(livro);}
}
