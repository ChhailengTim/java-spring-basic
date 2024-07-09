package com.lengcode;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/teacher")
public class Main {

    private final TeacherRepository teacherRepository;

    public Main(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("")
    public List<Teacher> getTeacher(){
        return teacherRepository.findAll();
    }

}
