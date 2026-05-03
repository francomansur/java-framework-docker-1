package br.com.tolearn.service;

import br.com.tolearn.dao.UsuarioDAO;
import br.com.tolearn.model.Usuario;

import java.util.List;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticar(String login, String senha) {
        if (login == null || login.isBlank() || senha == null || senha.isBlank()) {
            return null;
        }
        return this.usuarioDAO.buscarPorLoginESenha(login, senha);
    }

    public List<Usuario> listar() {
        return this.usuarioDAO.listarTodos();
    }

    public Usuario buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        return this.usuarioDAO.buscarPorId(id);
    }

    public void inserir(Usuario usuario) {
        if (usuario == null || usuario.getLogin() == null || usuario.getLogin().isBlank()) {
            throw new IllegalArgumentException("Login e obrigatorio.");
        }
        this.usuarioDAO.inserir(usuario);
    }

    public void alterar(Usuario usuario) {
        if (usuario == null || usuario.getId() == null || usuario.getLogin() == null || usuario.getLogin().isBlank()) {
            throw new IllegalArgumentException("Id e login sao obrigatorios.");
        }
        this.usuarioDAO.alterar(usuario);
    }

    public void deletar(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id e obrigatorio.");
        }
        this.usuarioDAO.deletar(id);
    }
}
