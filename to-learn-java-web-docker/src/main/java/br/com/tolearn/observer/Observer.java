package br.com.tolearn.observer;

import java.util.List;

public interface Observer {
    
    void atualizar(double novoPreco);
    List<String> getLogs();
}
