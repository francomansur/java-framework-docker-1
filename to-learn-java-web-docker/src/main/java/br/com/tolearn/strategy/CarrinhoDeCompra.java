package br.com.tolearn.strategy;

public class CarrinhoDeCompra {
    
    private EstrategiaPagamento estrategia;

    public void setEstrategia(EstrategiaPagamento estrategia) {
        if (estrategia == null) {
            return;
        }
        this.estrategia = estrategia;
    }

    public String realizarPagamento(double valor) {
        if (estrategia == null) {
            return "Nenhuma estratégia de pagamento definida.";
        }
        return estrategia.processarPagamento(valor);
    }
}
