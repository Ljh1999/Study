package com.jdbc.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类，用来得到连接和释放资源
 */
@SuppressWarnings({"all"})
public class JdbcUtils {
    private static String url; //url
    private static String driver;  //驱动
    private static String user;  //用户名
    private static String password;  //密码

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src\\mysqlconnection.properties"));
             url = properties.getProperty("url");
             driver = properties.getProperty("driver");
             user = properties.getProperty("user");
             password = properties.getProperty("password");
        } catch (IOException e) {
            //将编译异常转成运行异常抛出，调用者可以根据自己的需要，选择捕获该异常或按默认方式处理
            throw new RuntimeException(e);
        }
    }

    //得到连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //释放资源,可能需要释放的资源有ResultSet，Statement，preparedStatement,Connection
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
