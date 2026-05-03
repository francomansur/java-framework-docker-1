package br.com.tolearn.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.tolearn.strategy.CarrinhoDeCompra;
import br.com.tolearn.strategy.CartaoCredito;
import br.com.tolearn.strategy.Paypal;
import br.com.tolearn.strategy.Pix;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/strategy")
public class StrategyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        double valor = 150.00;

        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();

        out.println("<h2>Strategy - Carrinho de Compra</h2>");

        carrinho.setEstrategia(new Pix());
        out.println("<p>" + carrinho.realizarPagamento(valor) + "</p>");

        carrinho.setEstrategia(new CartaoCredito());
        out.println("<p>" + carrinho.realizarPagamento(valor) + "</p>");

        carrinho.setEstrategia(new Paypal());
        out.println("<p>" + carrinho.realizarPagamento(valor) + "</p>");
    }    
}
