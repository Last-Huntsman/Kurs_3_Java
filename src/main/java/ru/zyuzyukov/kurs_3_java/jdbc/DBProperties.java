package ru.zyuzyukov.kurs_3_java.jdbc;

import java.io.IOException;
import java.util.Properties;

public final class DBProperties {
    private static final Properties INSTANCE = new Properties();
    static {
        loadProperties();
    }
    private static void loadProperties() {
        try(var inputStream = DBProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
        INSTANCE.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key) {
        return INSTANCE.getProperty(key);
    }
    private DBProperties() {

    }
}

