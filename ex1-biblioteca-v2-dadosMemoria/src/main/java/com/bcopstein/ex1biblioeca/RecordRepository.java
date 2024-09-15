package com.bcopstein.ex1biblioeca;

import java.util.List;

public interface RecordRepository {
    List<Livro> getLivros();
    List<Usuario> getUsuarios();
    void cadastrarUsuario(Usuario usuario);
}

