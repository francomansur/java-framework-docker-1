package br.com.tolearn.observer;

import java.util.ArrayList;
import java.util.List;

public class AppCelular implements Observer {

    private List<String> logs = new ArrayList<>();

    @Override
    public void atualizar(double novoPreco) {
        logs.add("[App Celular] Notificação: novo preço R$" + novoPreco);
    }

    @Override
    public List<String> getLogs() {
        return logs;
    }
}
