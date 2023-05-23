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
        return dao.findById(id);
    }

    @Override
    public int insert(Student stu) {
        return dao.insert(stu);
    }

    @Override
    public int update(Student stu) {
        return dao.update(stu);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }
}
