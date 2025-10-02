package ru.zyuzyukov.kurs_3_java.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String url = DBProperties.getProperty("db.url");
    private static final String user = DBProperties.getProperty("db.username");
    private static final String password = DBProperties.getProperty("db.password");

    public  Connection open(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password) ;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
