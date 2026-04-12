package br.com.tolearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.tolearn.facade.HomeTheaterFacade;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/facade")
public class FacadeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            HomeTheaterFacade homeTheater = new HomeTheaterFacade();

            out.println("<h2>Facade - Home Theater</h2>");

            out.println("<h3>Estado inicial:</h3>");
            List<String> statusInicial = homeTheater.getStatus();
            for (String status : statusInicial) {
                out.println("<p>" + status + "</p>");
            }

            out.println("<h3>Assistir Filme:</h3>");
            homeTheater.assistirFilme();
            List<String> statusAssistindo = homeTheater.getStatus();
            for (String status : statusAssistindo) {
                out.println("<p>" + status + "</p>");
            }

            out.println("<h3>Desligar Filme:</h3>");
            homeTheater.desligarFilme();
            List<String> statusDesligado = homeTheater.getStatus();
            for (String status : statusDesligado) {
                out.println("<p>" + status + "</p>");
            }
        }

}
