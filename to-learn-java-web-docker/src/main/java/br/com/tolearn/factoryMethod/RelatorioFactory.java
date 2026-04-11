package br.com.tolearn.factoryMethod;

public class RelatorioFactory {

    public static Relatorio criarRelatorio(String tipo) {

        if (tipo == null) {
            return null;
        }
        
        switch (tipo.toLowerCase()) {
            case "pdf":   return new RelatorioPDF();
            case "excel": return new RelatorioExcel();
            case "html":  return new RelatorioHtml();
            default:      return null;
        }
    }
}
