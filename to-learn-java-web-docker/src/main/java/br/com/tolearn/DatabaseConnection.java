package br.com.tolearn;

import java.sql.ResultSet;

public class DatabaseConnection {
    private String jdbc = "jdbc:mysql://mysql:3306/teste";
    private String username = "teste";
    private String password = "teste";
    private java.sql.Connection connection;
    private static DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        try {
            if (connection != null && !connection.isClosed()) {
                return;
            }
            // Carrega o driver JDBC do MySQL (estava dando erro de driver não encontrado)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(jdbc, username, password);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();    
        } catch (ClassNotFoundException e) { // Trata o erro de driver não encontrado
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) {
        try {
            java.sql.Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
