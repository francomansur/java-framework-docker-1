package br.com.tolearn.decorator;

public class HamburgerBase implements Hamburger {

    @Override
    public String getDescricao() {
        return "Hambúrguer";
    }

    @Override
    public double getPreco() {
        return 10.0;
    }
}