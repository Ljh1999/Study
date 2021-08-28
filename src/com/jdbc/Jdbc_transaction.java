package com.jdbc;

import com.jdbc.Utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Jdbc 中事务的案例
 */
@SuppressWarnings("all")
public class Jdbc_transaction {
    //没有事务控制
    @Test
    public void noTransaction() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update account set money = money - 100 where id = ?";
        String sql2 = "update account set money = money + 100 where id = ?";
        try {
            connection = JdbcUtils.getConnection();     //在默认情况下，connection会自动提交commit
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            int i = preparedStatement.executeUpdate();
            System.out.println(i > 0 ? "操作成功" : "操作失败");

            int a = 1 / 0;   //模拟一个异常

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, 2);
            int res = preparedStatement.executeUpdate();
            System.out.println(res > 0 ? "操作成功" : "操作失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
    //事务控制
    @Test
    public void Transaction() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update account set money = money - 100 where id = ?";
        String sql2 = "update account set money = money + 100 where id = ?";
        try {
            connection = JdbcUtils.getConnection();     //在默认情况下，connection会自动提交commit
            //取消自动提交事务
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            int i = preparedStatement.executeUpdate();
            System.out.println(i > 0 ? "操作成功" : "操作失败");

            //int a = 1 / 0;   //模拟一个异常

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, 2);
            int res = preparedStatement.executeUpdate();
            System.out.println(res > 0 ? "操作成功" : "操作失败");
            //没有发生异常才提交
            connection.commit();
        } catch (SQLException e) {
            //如果发生异常就回滚事务
            System.out.println("发生异常，回滚事务");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
}
