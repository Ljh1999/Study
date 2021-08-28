package com.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 研究java 连接mysql的5种方式
 */
@SuppressWarnings({"all"})
public class Jdbc_exercise02 {
    //方式1：属于静态加载，灵活性差，依赖性强
    @Test
    public void connect_1() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("useSSL", "true");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
        connect.close();
    }
    //方式2：使用反射加载Driver类，属于动态加载，更加灵活，减少了依赖性
    @Test
    public void connect_2() throws SQLException {
        try {
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) aClass.newInstance();
            String url = "jdbc:mysql://localhost:3306/db";
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "root");
            properties.setProperty("useSSL", "true");
            Connection connect = driver.connect(url, properties);
            System.out.println(connect);
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //方式3：使用DriverManager
    @Test
    public void connect_3() throws SQLException {
        try {
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) aClass.newInstance();
            String url = "jdbc:mysql://localhost:3306/db";
            String user = "root";
            String password = "root";
            DriverManager.registerDriver(driver); //注册Driver驱动
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //方式4：使用Class.forName 自动完成注册驱动，简化代码
    //用的最多的一种方式
    @Test
    public void connect_4() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //方式5：在方式4的基础上改进，增加配置文件，使连接mysql更加灵活
    @Test
    public void connect_5() throws SQLException {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src\\mysqlconnection.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(properties.getProperty("driver"));
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
