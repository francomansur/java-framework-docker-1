package br.com.tolearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.tolearn.adapter.CalculadorFrete;
import br.com.tolearn.adapter.FreteAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adapter")
public class AdapterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h2>Adapter - Integração de APIs de Frete</h2>");

        CalculadorFrete calculador = new FreteAdapter();

        double peso1 = 5.0;
        double distancia1 = 100.0;
        double custo1 = calculador.calcular(peso1, distancia1);
        out.println("<p>Peso: " + peso1 + "kg | Distância: " + distancia1 + "km | Custo: R$" + custo1 + "</p>");

        double peso2 = 10.0;
        double distancia2 = 250.0;
        double custo2 = calculador.calcular(peso2, distancia2);
        out.println("<p>Peso: " + peso2 + "kg | Distância: " + distancia2 + "km | Custo: R$" + custo2 + "</p>");
    }
}
