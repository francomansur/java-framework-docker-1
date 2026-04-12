package br.com.tolearn.decorator;

public class Bacon extends HamburgerDecorator {

    public Bacon(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String getDescricao() {
        return hamburger.getDescricao() + " + Bacon";
    }

    @Override
    public double getPreco() {
        return hamburger.getPreco() + 3.0;
    }
}