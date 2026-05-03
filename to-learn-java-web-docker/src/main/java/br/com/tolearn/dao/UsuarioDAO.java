package br.com.tolearn.dao;

import br.com.tolearn.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO = Data Access Object (acesso ao banco)
 *
 * Somente SQL e conversao ResultSet -> {@link Usuario}.
 * Quem decide "quando" chamar cada metodo e o Service / Controller.
 */
public class UsuarioDAO extends MySqlDAO {

    public UsuarioDAO() {
        super();
    }

    public Usuario buscarPorLoginESenha(String login, String senha) {
        String sql = "SELECT id, login, senha FROM usuarios WHERE login = ? AND senha = ?";
        try (ResultSet rs = super.executar(sql, login, senha)) {
            if (rs.next()) {
                return super.mapearSimples(rs, Usuario.class);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuario.", e);
        }
        return null;
    }

    public List<Usuario> listarTodos() {
        String sql = "SELECT id, login, senha FROM usuarios ORDER BY id";
        List<Usuario> lista = new ArrayList<>();
        try (ResultSet rs = super.executar(sql)) {
            while (rs.next()) {
                lista.add(super.mapearSimples(rs, Usuario.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuarios.", e);
        }
        return lista;
    }

    public Usuario buscarPorId(Long id) {
        String sql = "SELECT id, login, senha FROM usuarios WHERE id = ?";
        try (ResultSet rs = super.executar(sql, id)) {
            if (rs.next()) {
                return super.mapearSimples(rs, Usuario.class);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar por id.", e);
        }
        return null;
    }

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";
        try {
            super.executarUpdate(sql, usuario.getLogin(), usuario.getSenha());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir.", e);
        }
    }

    public void alterar(Usuario usuario) {
        String sql = "UPDATE usuarios SET login = ?, senha = ? WHERE id = ?";
        try {
            super.executarUpdate(sql, usuario.getLogin(), usuario.getSenha(), usuario.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar.", e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            super.executarUpdate(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar.", e);
        }
    }
}
