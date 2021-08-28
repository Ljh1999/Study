package com.jdbc;

import com.jdbc.Utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试工具类的DML操作
 */
@SuppressWarnings({"all"})
public class Jdbc_utilsDMLTest {
    @Test
    public void jdbcUtilsDMLTest() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update admin set username = ? where id = ?";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 1);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("操作成功");
            } else {
                System.out.println("操作失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void jdbcUtilsTest() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select id,username,password from admin";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                System.out.println(id + "\t" + name + "\t" + pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, null, connection);
        }
    }
}
