package br.com.tolearn.facade;

public class Amplificador {

    private boolean ligado = false;

    public void ligarDesligar() {
        if (this.ligado == false) {
            this.ligado = true;
        } else {
            this.ligado = false;
        }
    }

    public boolean getLigado() {
        return this.ligado;
    }
}
