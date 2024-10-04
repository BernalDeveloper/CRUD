package com.crud.spring.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.spring.app.models.Student;
import com.crud.spring.app.repository.IStudent;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudent data;

    @Override
    public List<Student> findAll() {
        return (List<Student>)data.findAll();
    }

    @Override
    public int save(Student student) {
        int res=0;
        Student s = data.save(student);
        if(!s.equals(null)){
            res=1;
        }
        return res;
    }
}