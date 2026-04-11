package br.com.tolearn.singleton;

public class ConfiguracaoGlobal {
    String dbUrl = "jdbc:mysql://mysql";
    String banco = "teste";
    int porta = 3306;
    String dbUrlCompleta = dbUrl + ":" + porta + "/" + banco;
    int timeout = 30;

    private static ConfiguracaoGlobal instance;

    private ConfiguracaoGlobal() {}

    public static ConfiguracaoGlobal getInstance() {
        if (instance == null) {
            instance = new ConfiguracaoGlobal();
        }
        return instance;
    }

    public void getDbInfo() {
        System.out.println("URL: " + this.dbUrlCompleta + ", Porta: " + this.porta + ", Timeout: " + this.timeout);
    }
}
