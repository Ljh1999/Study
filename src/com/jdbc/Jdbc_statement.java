package com.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示 SQL注入问题
 */
@SuppressWarnings({"ALL"})
public class Jdbc_statement {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysqlconnection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = "select id,username,password from admin where username = '" + username + "' and password = '" + pwd + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        //sql注入成功则查出所有用户名和密码
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String mm = resultSet.getString(3);
            System.out.println(id + "\t" + name + "\t" + mm);
        }
    }
}
