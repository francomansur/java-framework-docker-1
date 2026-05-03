package br.com.tolearn.controller.annotation;

import br.com.tolearn.model.Usuario;
import br.com.tolearn.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {

    private final UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if ("form".equals(acao)) {
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isBlank()) {
                Usuario usuario = usuarioService.buscarPorId(Long.parseLong(idParam));
                request.setAttribute("usuario", usuario);
            }
            request.getRequestDispatcher("/usuario/form.jsp").forward(request, response);
            return;
        }

        if ("deletar".equals(acao)) {
            String idParam = request.getParameter("id");
            usuarioService.deletar(Long.parseLong(idParam));
            response.sendRedirect(request.getContextPath() + "/usuarios");
            return;
        }

        request.setAttribute("usuarios", usuarioService.listar());
        request.getRequestDispatcher("/usuario/lista.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        Usuario usuario = new Usuario();
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));

        if ("alterar".equals(acao)) {
            usuario.setId(Long.parseLong(request.getParameter("id")));
            usuarioService.alterar(usuario);
        } else {
            usuarioService.inserir(usuario);
        }

        response.sendRedirect(request.getContextPath() + "/usuarios");
    }
}
