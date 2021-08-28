package com.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示 PreparedStatement DML语句的使用
 */
@SuppressWarnings({"All"})
public class Jdbc_PreparedStatementDml {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入要删除的用户名：");
        String username = scanner.nextLine();
//        System.out.println("请输入密码：");
//        String pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysqlconnection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        //String sql = "insert into admin(username,password) values(?,?)";
        //String sql = "update admin set password = ? where username = ?";
        String sql = "delete from admin where  username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, pwd);
        preparedStatement.setString(1, username);
        int res = preparedStatement.executeUpdate();
        if (res > 0) {
            System.out.println("操作成功");
        } else {
            System.out.println("操作失败");
        }
    }
}
