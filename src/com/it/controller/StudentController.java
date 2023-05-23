package com.it.controller;

import com.it.domain.Student;
import com.it.service.StudentService;
import com.it.service.StudentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class StudentController {
    private StudentService service = new StudentServiceImpl();

    @Test
    public void findAll() {
        ArrayList<Student> list = service.findAll();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    @Test
    public void findByID() {
        Student stu = service.findById(3);
        System.out.println(stu);
    }

    @Test
    public void insert() {
        Student stu = new Student(5, "周七", 28, new Date());
        int result = service.insert(stu);
        if (result != 0) {
            System.out.println("insert OK!");
        } else {
            System.out.println("insert fail!");
        }
    }

    @Test
    public void update() {
        Student stu = service.findById(5);
        stu.setName("周奇奇");
        int result = service.update(stu);
        if (result != 0) {
            System.out.println("update OK!");
        } else {
            System.out.println("update fail!");
        }
    }

    @Test
    public void delete() {
        int result = service.delete(5);
        if (result != 0) {
            System.out.println("delete OK!");
        } else {
            System.out.println("delete fail!");
        }
    }
}
