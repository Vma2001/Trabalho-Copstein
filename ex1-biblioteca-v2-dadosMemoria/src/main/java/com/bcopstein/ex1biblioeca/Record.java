package com.bcopstein.ex1biblioeca;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Record implements RecordRepository {
private JdbcTemplate jdbcTemplate;
    public Record(JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate = jdbcTemplate1;
    }

    public List<Livro> getLivros() {
        return jdbcTemplate.query("SELECT * from livros",
                (rs, rowNum)
                -> new Livro(rs.getInt("codigo"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getInt("ano")));

    }

   // public boolean add(Livro livro){return jdbcTemplate.update(livro);}
}
