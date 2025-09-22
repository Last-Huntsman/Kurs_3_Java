package ru.zyuzyukov.kurs_3_java.jdbc;


import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCRunner {
    public static void main(String[] args) throws SQLException {
        new JDBCRunner().run();
    }

    private final ConnectionManager connectionManager = new ConnectionManager();
    public void run() throws SQLException {
        try (var connection  = connectionManager.open()) {

        }
    }
}
