package com.bcopstein.ex1biblioeca;

import java.sql.Date;

public class usuario {
    private String nome;
    private Date anoNascimento;
    private int codigo;

    public usuario(String nome, Date anoNascimento, int codigo) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }

    public Date getAnoNascimento() {
        return anoNascimento;
    }

    public int getCodigo() {
        return codigo;
    }
}
