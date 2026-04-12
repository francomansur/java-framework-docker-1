package br.com.tolearn.adapter;

public class FreteAdapter implements CalculadorFrete {

    private FreteAntigoXML freteAntigo;

    public FreteAdapter() {
        this.freteAntigo = new FreteAntigoXML();
    }

    @Override
    public double calcular(double peso, double distancia) {
        String xml = "<peso>" + peso + "</peso><distancia>" + distancia + "</distancia>";
        return freteAntigo.obterCustoXML(xml);
    }
}
