package com.crud.spring.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.spring.app.models.Student;

@Service
public interface IStudentService {
    
    public List<Student> findAll();
    public int save(Student student);

}