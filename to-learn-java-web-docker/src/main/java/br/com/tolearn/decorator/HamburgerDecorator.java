package br.com.tolearn.decorator;

public abstract class HamburgerDecorator implements Hamburger {
    
    Hamburger hamburger;

    public HamburgerDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
    }
}
