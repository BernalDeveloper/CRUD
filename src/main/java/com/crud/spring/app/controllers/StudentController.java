package com.crud.spring.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.spring.app.models.Student;
import com.crud.spring.app.repository.IStudent;

@Controller
@RequestMapping
public class StudentController {
    
    @Autowired
    private IStudent service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Student>students=service.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("student", new Student());
        return "form";
    }
    
    @PostMapping("/save")
    public String save(@Validated Student student, Model model){
        service.save(student);
        return "redirect:/listar";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Student>student=service.findById(id);
        model.addAttribute("student", student);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        service.deleteById(id);
        return "redirect:/listar";
    }
}