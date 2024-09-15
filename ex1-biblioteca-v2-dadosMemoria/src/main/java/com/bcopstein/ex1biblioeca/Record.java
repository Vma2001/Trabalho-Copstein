package com.bcopstein.ex1biblioeca;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Record implements RecordRepository {
private final JdbcTemplate jdbcTemplate;
    public Record(JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate = jdbcTemplate1;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public List<Livro> getLivros() {
        return jdbcTemplate.query("SELECT * from livros",
                (rs, rowNum)
                -> new Livro(rs.getInt("codigo"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getInt("ano")));
    }

    public List<Usuario> getUsuarios() {
        return jdbcTemplate.query("SELECT * FROM usuario", (rs, rowNum) ->
                new Usuario(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getInt("ano_de_nascimento")
                )
        );
    }

    public void cadastrarUsuario(Usuario usuario) {
        jdbcTemplate.update(
                "INSERT INTO usuario (nome, ano_de_nascimento) VALUES (?, ?)",
                usuario.getNome(), usuario.getAnoNascimento()
        );
    }

    public void atualizarCodigoUsuarioLivro(int id, int codigoUsuario) {
        String sql = "UPDATE livros SET codigo_usuario = ? WHERE codigo = ?";
        jdbcTemplate.update(sql, codigoUsuario, id);
    }

    public Livro getLivroPorId(int id) {
        List<Livro> livros = jdbcTemplate.query("SELECT * FROM livros WHERE codigo = ?",
                new Object[]{id},
                (rs, rowNum) -> {
                    Livro livro = new Livro(
                            rs.getInt("codigo"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("ano")
                    );
                    livro.setCodigoUsuario(rs.getInt("codigo"));
                    return livro;
                });

        if (livros.isEmpty()) {
            return null;
        } else {
            return livros.get(0);
        }
    }

    public List<Livro> getLivrosDisponiveis() {
        return jdbcTemplate.query("SELECT * FROM livros WHERE cod_usuario = -1",
                (rs, rowNum) -> {
                    Livro livro = new Livro(
                            rs.getInt("codigo"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("ano")
                    );
                    livro.setCodigoUsuario(rs.getInt("codigo_usuario"));
                    return livro;
                });
    }

    public List<Livro> getLivrosEmprestadosPorUsuario(int codigoUsuario) {
        return jdbcTemplate.query("SELECT * FROM livros WHERE codigo_usuario = ?",
                new Object[]{codigoUsuario},
                (rs, rowNum) -> {
                    Livro livro = new Livro(
                            rs.getInt("codigo"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("ano")
                    );
                    livro.setCodigoUsuario(rs.getInt("codigo_usuario"));
                    return livro;
                });
    }

}





   // public boolean add(Livro livro){return jdbcTemplate.update(livro);}

