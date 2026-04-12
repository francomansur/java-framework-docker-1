package br.com.tolearn.adapter;

public class FreteAntigoXML {

    public double obterCustoXML(String xmlDados) {
        
        double peso = extrairValor(xmlDados, "peso");
        double distancia = extrairValor(xmlDados, "distancia");
        return peso * distancia * 0.5;
    }

    private double extrairValor(String xml, String tag) {
        String abre = "<" + tag + ">";
        String fecha = "</" + tag + ">";
        int inicio = xml.indexOf(abre) + abre.length();
        int fim = xml.indexOf(fecha);
        return Double.parseDouble(xml.substring(inicio, fim));
    }
}
