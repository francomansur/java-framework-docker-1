package br.com.tolearn.decorator;

public class Queijo extends HamburgerDecorator {

    public Queijo(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String getDescricao() {
        return hamburger.getDescricao() + " + Queijo";
    }

    @Override
    public double getPreco() {
        return hamburger.getPreco() + 2.0;
    }
}