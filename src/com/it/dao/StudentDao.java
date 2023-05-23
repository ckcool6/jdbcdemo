package com.it.dao;

import com.it.domain.Student;

import java.util.ArrayList;

public interface StudentDao {
    public abstract ArrayList<Student> findAll();
    public abstract Student findById(Integer id);
    public abstract int insert(Student stu);
    public abstract int update(Student stu);
    public abstract int delete(Integer id);
}
