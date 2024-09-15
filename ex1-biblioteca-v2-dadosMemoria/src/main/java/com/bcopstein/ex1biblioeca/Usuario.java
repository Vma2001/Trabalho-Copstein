package com.bcopstein.ex1biblioeca;

public class Usuario {

    private int codigo;
    private String nome;
    private int anoNascimento;

    public Usuario(int codigo, String nome, int anoNascimento){
        this.codigo = codigo;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
}
