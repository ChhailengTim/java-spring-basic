package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentService {
	public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Leng", "Leng@gssmail.com", LocalDate.of(1999, 8, 21), 25)
        );
    }

}
