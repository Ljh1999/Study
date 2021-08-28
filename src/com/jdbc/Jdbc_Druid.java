package com.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jdbc.Utils.JdbcDruidUtils;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Druid连接池
 */
@SuppressWarnings("ALL")
public class Jdbc_Druid {
    @Test
    public void druidTest() throws Exception {
        //1.加入 Druid jar包
        //2.加入 配置文件druid.properties,将该文件拷贝到项目的src目录
        //3.创建properties，用来读取配置文件
        Properties properties = new Properties();
        properties.load(new FileReader("src\\druid.properties"));
        //4.创建一个指定参数的数据库连接池，Druid的连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "insert into admin values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"周杰伦");
        preparedStatement.setString(2,"666666");
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "操作成功" : "操作失败");
    }
    @Test
    public void druidTest2() throws Exception {
        Connection connection = JdbcDruidUtils.getConnection();
        String sql = "select * from admin where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"周杰伦");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println(id + "\t" + username + "\t" + password);
        }
    }
}
