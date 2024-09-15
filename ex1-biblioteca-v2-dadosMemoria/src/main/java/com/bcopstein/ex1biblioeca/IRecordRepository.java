package com.bcopstein.ex1biblioeca;

import java.util.List;

public interface IRecordRepository {
    public List<livros> getLivros();
    public boolean add(livros livros);
    public void EmprestaLivro(livros livros);
}
