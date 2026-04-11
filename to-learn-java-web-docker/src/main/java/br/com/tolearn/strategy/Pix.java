package br.com.tolearn.strategy;

public class Pix implements EstrategiaPagamento{
    
    @Override
    public String processarPagamento(double valor) {
        return "Pagamento de R$" + valor + " processado com PIX.";
    }
}
