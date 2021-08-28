package com.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 使用 PreparedStatemend预处理
 */
@SuppressWarnings({"all"})
public class Jdbc_PreparedStatemend {
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
        String sql = "select username,password from admin where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, pwd);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
