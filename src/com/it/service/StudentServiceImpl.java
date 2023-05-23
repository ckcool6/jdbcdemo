package com.it.service;

import com.it.dao.StudentDao;
import com.it.dao.StudentDaoImpl;
import com.it.domain.Student;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService{
    private StudentDao dao = new StudentDaoImpl();
    @Override
    public ArrayList<Student> findAll() {
        return dao.findAll();
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
