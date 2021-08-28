package com.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
@SuppressWarnings({"all"})
public class Jdbc_exerciese03 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src\\mysqlconnection.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "insert into actor values(null,'刘德华','男','1999-01-1','11241234545')";
            int res = 0;
            for (int i = 1; i <= 5; i++) {
                res = statement.executeUpdate(sql);
            }
            System.out.println(res > 0 ? "操作成功" : "操作失败");
            connection.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
