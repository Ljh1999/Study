package com.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 第一个jdbc程序
 */
@SuppressWarnings({"all"})
public class Jdbc_exercise01 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connect = null;
        try {
            //加载驱动
            Driver driver = new Driver();
            //得到连接
            String url = "jdbc:mysql://localhost:3306/db";
            Properties properties = new Properties();
            properties.setProperty("user","root");
            properties.setProperty("password","root");
            properties.setProperty("useSSL","true");
             connect = driver.connect(url, properties);
            //通过statement执行增删改
            //String sql = "insert into actor values(null,'刘德华','男','1999-01-1','11241234545')";
            //String sql = "update actor set  name = '周星驰' where id = 1";
            String sql = "delete from actor  where id = 1";
            statement = connect.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i > 0 ? "操作成功" : "操作失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connect != null){
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
