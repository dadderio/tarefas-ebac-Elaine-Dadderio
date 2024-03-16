package br.com.dadderio.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    /*construtor privado*/
    private ConnectionFactory(Connection connection){

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null){
            connection = initConnection();
            return connection;
        } else if (connection.isClosed()) {
            connection = initConnection();
            return connection;
        } else {
            return connection;
        }
    }

    private static Connection initConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ebac", "postgres", "admin");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
