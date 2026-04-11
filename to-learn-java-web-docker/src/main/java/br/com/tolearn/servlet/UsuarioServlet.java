package br.com.tolearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tolearn.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // 1. Obtém a instância única da classe DatabaseConnection
            DatabaseConnection db = DatabaseConnection.getInstance();
            // 2. Conecta-se ao banco de dados
            db.connect();
            // 3. Executa a consulta SQL
            ResultSet result = db.query("SELECT * FROM usuarios");
            // 4. Exibe os resultados na tela do navegador
            out.println("<h2>Lista de Usuários</h2>");
            out.println("<ul>");
            while (result.next()) {
                out.println("<li>" + result.getString("nome") + "</li>");
            }
            out.println("</ul>");
        } catch (SQLException e) {
            out.println("<p>Erro no banco de dados: " + e.getMessage() + "</p>");
        }
    }
    
}