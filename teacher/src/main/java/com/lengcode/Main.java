package com.lengcode;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    record NewTeacherRequest(String name,
                             String email,
                             Integer age){

    }

    @PostMapping
    public ResponseEntity<String> addTeacher (@RequestBody NewTeacherRequest request){
        Teacher teacher = new Teacher();
        teacher.setName(request.name());
        teacher.setEmail(request.email());
        teacher.setAge(request.age());
        teacherRepository.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body("Teacher added successfully!");
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("teacherId") Integer id){
        if (teacherRepository.existsById(id)){
            teacherRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Teacher deleted successfully!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found!");
        }
    }

    @PutMapping("{teacherId}")
    public ResponseEntity<String> updateTeacher(@PathVariable("teacherId") Integer id,
                              @RequestBody NewTeacherRequest request) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.setName(request.name());
            teacher.setEmail(request.email());
            teacher.setAge(request.age());
            teacherRepository.save(teacher);
            return ResponseEntity.status(HttpStatus.OK).body("Teacher updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found!");
        }
    }

}
