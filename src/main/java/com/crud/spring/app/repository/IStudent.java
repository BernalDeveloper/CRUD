package com.crud.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.spring.app.models.Student;

@Repository
public interface IStudent extends JpaRepository<Student, Integer>{
}