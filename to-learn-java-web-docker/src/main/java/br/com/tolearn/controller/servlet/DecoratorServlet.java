package br.com.tolearn.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.tolearn.decorator.Bacon;
import br.com.tolearn.decorator.Hamburger;
import br.com.tolearn.decorator.HamburgerBase;
import br.com.tolearn.decorator.Queijo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/decorator")
public class DecoratorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h2>Decorator - Hambúrguer</h2>");

        Hamburger hamburger = new HamburgerBase();
        out.println("<p>" + hamburger.getDescricao() + " - R$" + hamburger.getPreco() + "</p>");

        hamburger = new Queijo(hamburger);
        out.println("<p>" + hamburger.getDescricao() + " - R$" + hamburger.getPreco() + "</p>");

        hamburger = new Bacon(hamburger);
        out.println("<p>" + hamburger.getDescricao() + " - R$" + hamburger.getPreco() + "</p>");
    }
}