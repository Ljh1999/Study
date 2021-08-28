package com.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

@SuppressWarnings({"All"})
public class Jdbc_ResultSet {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysqlconnection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = "select id,name,sex,brondate,phone from actor";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date date = resultSet.getDate("brondate");
            String phone = resultSet.getString("phone");
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date + "\t" + phone);
        }
        resultSet.close();
        connection.close();
        statement.close();
    }
}
