package com.bcopstein.ex1biblioeca;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.bcopstein.ex1biblioeca.utils;

import java.util.List;

@Service
public class Record implements IRecordRepository {
    private utils utils;
    private JdbcTemplate jdbcTemplate;

    public Record(JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate = jdbcTemplate1;
    }

    public List<livros> getLivros() {
        return jdbcTemplate.query("SELECT * from livros",
                (rs, rowNum)
                        -> new livros(rs.getInt("codigo"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano")));

    }

    public boolean add(livros livros) {
        String sql = "INSERT INTO livros (titulo, autor, ano, codigo) VALUES (?, ?, ?, ?)";

        int result = jdbcTemplate.update(sql,
                livros.getTitulo(),
                livros.getAutor(),
                livros.getAno(),
                livros.getId());

        return result > 0;
    }

    @Override
    public void EmprestaLivro(livros livros, Usuario) {
        if(utils.VerificaLivro(livros)){return;}
        else{

        }
    }
}
