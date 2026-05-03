package br.com.tolearn.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.tolearn.observer.Acao;
import br.com.tolearn.observer.Observer;
import br.com.tolearn.observer.AppCelular;
import br.com.tolearn.observer.PainelWeb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/observer")
public class ObserverServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        Acao acao = new Acao();
        acao.adicionarObserver(new AppCelular());
        acao.adicionarObserver(new PainelWeb());

        out.println("<h2>Observer - Ação na Bolsa</h2>");

        out.println("<h3>Preço atualizado para R$75.50</h3>");
        acao.setPreco(75.50);
        out.println("<h3>Preço atualizado para R$80.50</h3>");
        acao.setPreco(80.50);
        out.println("<h3>Preço atualizado para R$90.50</h3>");
        acao.setPreco(90.50);

        out.println("<h3>Logs dos Observers:</h3>");
        for (Observer obs : acao.getObservers()) {
            for (String msg : obs.getLogs()) {
                out.println("<p>" + msg + "</p>");
            }
        }
    }
}
