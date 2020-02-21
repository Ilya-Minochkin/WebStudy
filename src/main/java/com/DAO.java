package com;

import java.sql.*;

public class DAO {
    private String instanceName = "DESKTOP-5PKGG7D\\ilya";
    private String databaseName = "TestDB";
    private String userName = "";
    private String password = "";
    private String connectionUrl = "jdbc:sqlserver://%1%s;databaseName=%2%s;user=%3%s;password=%4%s;";
    private String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, password);
    private Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    {
        try {
            connection = DriverManager.getConnection(connectionString);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getFullInfo() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM dbo.Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
