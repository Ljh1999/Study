package com.jdbc;

import com.jdbc.Utils.JdbcDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用apche-DBUtils 工具类 + druid 完成对表的crud操作
 */
@SuppressWarnings("ALL")
public class Jdbc_DBUtils {
    //查询返回一个集合
    @Test
    public void testQueryMany() throws SQLException {
        //1.得到连接
        Connection connection = JdbcDruidUtils.getConnection();
        //2.使用DBUtils类和接口，先引入相关的jar文件
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from admin where id >= ?";
         /*
            1.query方法就是执行sql语句，得到resultset -- 封装到 -->ArrayList集合中
            2.返回一个集合
            3.参数列表：
               (1) connection:连接
               (2) sql :SQL语句
               (3) new BeanListHandler<>(Admin.class): 将resultset --> Admin对象
                   -- >封装到ArrayList集合中 -- > 底层使用反射机制去获取Admin的属性，然后进行封装
               (4) 1 :是给sql语句 中的？赋值的，可以有多个值，是一个可变参数Object... params
               (5) 底层得到的resultset会在query关闭，preparedStatement也会关闭
          */
        List<Admin> list = queryRunner.query(connection, sql, new BeanListHandler<>(Admin.class), 1);
        for (Admin admin : list) {
            System.out.println(admin);
        }
        JdbcDruidUtils.close(null, null, connection);
    }

    //查询返回单行记录
    @Test
    public void testQuerySingle() throws SQLException {
        //1.得到连接
        Connection connection = JdbcDruidUtils.getConnection();
        //2.使用DBUtils类和接口，先引入相关的jar文件
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from admin where id = ?";
        Admin admin = queryRunner.query(connection, sql, new BeanHandler<>(Admin.class), 1);
        System.out.println(admin);
        JdbcDruidUtils.close(null, null, connection);
    }

    //查询返回单行单列记录
    @Test
    public void testScalar() throws SQLException {
        //1.得到连接
        Connection connection = JdbcDruidUtils.getConnection();
        //2.使用DBUtils类和接口，先引入相关的jar文件
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select username from admin where id = ?";
        Object obj = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);
        System.out.println(obj);
        JdbcDruidUtils.close(null, null, connection);
    }

    //演示DML操作
    @Test
    public void testinsert() throws SQLException {
        //1.得到连接
        Connection connection = JdbcDruidUtils.getConnection();
        //2.使用DBUtils类和接口，先引入相关的jar文件
        QueryRunner queryRunner = new QueryRunner();
        //添加操作
//        String sql = "insert into admin values(null,?,?)";
//        int i = queryRunner.update(connection, sql, "林俊杰", "666");
        //修改操作
//        String sql = "update admin set password = ? where username = ?";
//        int i = queryRunner.update(connection, sql, "123456", "林俊杰");
        //删除操作
        String sql = "delete from admin where id = ?";
        int i = queryRunner.update(connection, sql, "10009");
        System.out.println(i > 0 ? "操作成功" : "操作失败");
        JdbcDruidUtils.close(null, null, connection);
    }
}
