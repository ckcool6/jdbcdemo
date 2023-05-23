package com.it.dao;

import com.it.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class StudentDaoImpl implements StudentDao {

    @Override
    public ArrayList<Student> findAll() {

        ArrayList<Student> list = new ArrayList<>();
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.11.130:3306/db14", "root", "ckns818");
            stat = con.createStatement();
            String sql = "select * from student";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");

                //封装成stu对象
                Student stu = new Student(sid,name,age,birthday);

                //将stu对象保存到集合
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //返回集合对象
        return list;
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public int insert(Student stu) {
        return 0;
    }

    @Override
    public int update(Student stu) {
        return 0;
    }

    @Override
    public int delete(Student stu) {
        return 0;
    }
}
