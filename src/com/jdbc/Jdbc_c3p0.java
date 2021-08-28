package com.jdbc;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;
@SuppressWarnings("ALL")
public class Jdbc_c3p0 {
    //第一种方式
    @Test
    public void testC3P0_01() throws Exception{
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件mysqlConnection.properties获取相关连接信息
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysqlConnection.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //给comboPooledDataSource设置参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //得到连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
//    第二种方式
    @Test
    public void testC3P0_02() throws Exception{
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("c3p0-config");
        //得到连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
