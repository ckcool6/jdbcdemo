package com.it.dao;

import com.it.domain.Student;
import com.it.utils.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
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
            con = JDBCUtils.getConnection();

            stat = con.createStatement();
            String sql = "select * from student";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");

                //封装成stu对象
                Student stu = new Student(sid, name, age, birthday);

                //将stu对象保存到集合
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(con, stat, rs);
        }
        //返回集合对象
        return list;
    }

    @Override
    public Student findById(Integer id) {

        Student stu = new Student();
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            con = JDBCUtils.getConnection();

            stat = con.createStatement();
            String sql = "select * from student where sid='" + id + "'";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");

                //封装成stu对象
                stu.setSid(sid);
                stu.setName(name);
                stu.setAge(age);
                stu.setBirthday(birthday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(con, stat, rs);
        }
        //
        return stu;
    }

    @Override
    public int insert(Student stu) {

        Connection con = null;
        Statement stat = null;
        int result = 0;

        try {
            con = JDBCUtils.getConnection();
            stat = con.createStatement();
            Date d = stu.getBirthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(d);
            String sql = "insert into student values ('" + stu.getSid() + "','" + stu.getName() + "','" + stu.getAge() + "','" + birthday + "')";
            stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(con, stat);
        }
        //
        return result;
    }

    @Override
    public int update(Student stu) {

        Connection con = null;
        Statement stat = null;
        int result = 0;

        try {
            con=JDBCUtils.getConnection();

            stat = con.createStatement();
            Date d = stu.getBirthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(d);
            String sql = "update student set sid='" + stu.getSid() + " ',name='" + stu.getName() + "',age='" + stu.getAge() + " ',birthday='" + birthday + " ' where sid='" + stu.getSid() + " '";
            result = stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(con,stat);

        }
        //
        return result;
    }

    @Override
    public int delete(Integer id) {
        Connection con = null;
        Statement stat = null;
        int result = 0;

        try {
            con=JDBCUtils.getConnection();

            stat = con.createStatement();
            String sql = "delete from student where sid='" + id + "'";
            result = stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.close(con,stat);
        }
        //
        return result;
    }
}
