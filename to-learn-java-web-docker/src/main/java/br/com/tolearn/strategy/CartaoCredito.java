package br.com.tolearn.strategy;

public class CartaoCredito implements EstrategiaPagamento {

    @Override
    public String processarPagamento(double valor) {
        return "Pagamento de R$" + valor + " processado com Cartão de Crédito.";
    }
}
