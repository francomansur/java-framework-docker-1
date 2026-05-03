package br.com.tolearn.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import br.com.tolearn.singleton.ConfiguracaoGlobal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/singleton")
public class SingletonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ConfiguracaoGlobal config = ConfiguracaoGlobal.getInstance();
        ConfiguracaoGlobal config2 = ConfiguracaoGlobal.getInstance();

        out.println("<h2>Singleton - ConfiguracaoGlobal</h2>");
        config.getDbInfo();
        out.println("<p>São o mesmo objeto? " + (config == config2) + "</p>");
    }
}
