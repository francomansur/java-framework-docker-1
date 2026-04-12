package br.com.tolearn.observer;

import java.util.ArrayList;
import java.util.List;

public class PainelWeb implements Observer {

    private List<String> logs = new ArrayList<>();

    @Override
    public void atualizar(double novoPreco) {
        logs.add("[Painel Web] Preço atualizado no painel: R$" + novoPreco);
    }

    @Override
    public List<String> getLogs() {
        return logs;
    }
}
