package br.com.tolearn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tolearn.config.MySqlSingleton;

public class MySqlDAO {

    protected final MySqlSingleton banco;

    public MySqlDAO() {
        this.banco = MySqlSingleton.getInstance();
    }

    protected ResultSet executar(String sql, Object... parametros) throws SQLException {
        return this.banco.executar(sql, parametros);
    }

    protected int executarUpdate(String sql, Object... parametros) throws SQLException {
        return this.banco.executarUpdate(sql, parametros);
    }

    protected <T extends Mapeavel> T mapearSimples(ResultSet rs, Class<T> classe) {
        try {
            T objeto = classe.getDeclaredConstructor().newInstance();
            objeto.preencher(rs);
            return objeto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao mapear objeto: " + e.getMessage(), e);
        }
    }
}
