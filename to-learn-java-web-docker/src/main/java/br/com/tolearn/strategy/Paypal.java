package br.com.tolearn.strategy;

public class Paypal implements EstrategiaPagamento {
    
    @Override
    public String processarPagamento(double valor) {
        return "Pagamento de R$" + valor + " processado com PayPal.";
    }
}
