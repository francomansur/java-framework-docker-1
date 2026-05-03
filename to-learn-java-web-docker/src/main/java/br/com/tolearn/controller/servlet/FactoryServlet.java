package br.com.tolearn.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.tolearn.factoryMethod.Relatorio;
import br.com.tolearn.factoryMethod.RelatorioFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/factoryMethod")
public class FactoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h2>Factory Method - Gerador de Relatórios</h2>");

        String[] tipos = {"pdf", "excel", "html"};
        for (String tipo : tipos) {
            Relatorio relatorio = RelatorioFactory.criarRelatorio(tipo);
            out.println("<p>" + relatorio.gerar() + "</p>");
        }
    }
} 

