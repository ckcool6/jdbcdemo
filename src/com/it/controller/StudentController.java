package com.it.controller;

import com.it.domain.Student;
import com.it.service.StudentService;
import com.it.service.StudentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;

public class StudentController {
    private StudentService service = new StudentServiceImpl();

    @Test
    public void findAll(){
        ArrayList<Student> list = service.findAll();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    @Test
    public void findByID(){

    }
}
