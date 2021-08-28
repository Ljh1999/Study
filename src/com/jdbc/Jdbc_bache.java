package com.jdbc;

import com.jdbc.Utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

/**
 * 演示批处理的使用
 */
public class Jdbc_bache {
    @Test
    public void bache() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into admin values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Instant start = Instant.now();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.addBatch();
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start,end).toMillis());
        JdbcUtils.close(null, preparedStatement, connection);
    }
}
