package com.epam.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionService {
    private final static String URL = "jdbc:mysql://localhost:3306/electric_appliance?useSSL=false";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "root";
    private static Connection connection;

    private ConnectionService() {
    }

    private static class ConnectionServiceHolder {
        private static final Connection INSTANCE = new ConnectionService().createConnection();
    }

    public static Connection getInstance() {
        return ConnectionServiceHolder.INSTANCE;
    }

    private Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }
        return connection;
    }
}
