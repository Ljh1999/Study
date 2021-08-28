package com.jdbc.dao.test;

import com.jdbc.dao.Dao.AdminDao;
import com.jdbc.dao.Dao.StudentDao;
import com.jdbc.dao.pojo.Admin;
import com.jdbc.dao.pojo.Student;
import org.junit.jupiter.api.Test;

import java.util.List;
@SuppressWarnings("ALL")
public class testDao {
    //测试查询多行数据
    @Test
    public void testQuery(){
        AdminDao adminDao = new AdminDao();
        List<Admin> admins = adminDao.queryMultiply("select * from admin where id >= ?", Admin.class, 1);
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }
    //测试DMl语句
    @Test
    public void testDml(){
        AdminDao adminDao = new AdminDao();
        int i = adminDao.dmlUpdate("insert into admin values(null,?,?) ", "林俊杰", "666");
        System.out.println(i > 0 ? "添加成功！" : "添加失败");
    }

    @Test
    public void testStudent(){
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.queryMultiply("select * from student", Student.class);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testStudentDMl(){
        StudentDao studentDao = new StudentDao();
        int i = studentDao.dmlUpdate("insert into student values(?,?,?,?)", 1, "王五", 32,121);
       System.out.println(i > 0 ?"操作成功" : "操作失败");
    }
}
