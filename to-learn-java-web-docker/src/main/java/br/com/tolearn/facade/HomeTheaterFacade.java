package br.com.tolearn.facade;

import java.util.ArrayList;
import java.util.List;

public class HomeTheaterFacade {

    public Amplificador amplificador = new Amplificador();
    public Luzes luzes = new Luzes();
    public Tv tv = new Tv();

    public void assistirFilme() {
        amplificador.ligarDesligar();
        luzes.ligarDesligar();
        tv.ligarDesligar();
    }

    public void desligarFilme() {
        amplificador.ligarDesligar();
        luzes.ligarDesligar();
        tv.ligarDesligar();
    }

    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        status.add("TV: " + (tv.getLigado() ? "Ligada" : "Desligada"));
        status.add("Amplificador: " + (amplificador.getLigado() ? "Ligado" : "Desligado"));
        status.add("Luzes: " + (luzes.getLigado() ? "Ligadas" : "Desligadas"));
        return status;
    }
}
