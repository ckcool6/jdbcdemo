package com.it.service;

import com.it.domain.Student;

import java.util.ArrayList;

public interface StudentService {
    public abstract ArrayList<Student> findAll();
    public abstract Student findById(Integer id);
    public abstract int insert(Student stu);
    public abstract int update(Student stu);
    public abstract int delete(Student stu);
}
