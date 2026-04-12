package br.com.tolearn.observer;

import java.util.ArrayList;
import java.util.List;

public class Acao {

    private List<Observer> observers = new ArrayList<>();
    private double preco;

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void setPreco(double novoPreco) {
        this.preco = novoPreco;
        notificar();
    }

    private void notificar() {
        for (Observer observer : observers) {
            observer.atualizar(preco);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
