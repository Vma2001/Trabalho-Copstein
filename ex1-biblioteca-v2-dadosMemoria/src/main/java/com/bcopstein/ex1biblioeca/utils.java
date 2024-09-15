package com.bcopstein.ex1biblioeca;

public class utils {
    public boolean VerificaLivro(livros livros){
        if(livros.getCod_usuario()!= -1){return true;}
        return false;
    }
}
