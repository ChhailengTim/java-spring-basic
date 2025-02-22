package com.example.demo.student;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

@Component
@Service
public class StudentService {
	
	 private final StudentRepository studentRepository;
	 
	 @Autowired
	 public StudentService(StudentRepository studentRepository) {
		 this.studentRepository = studentRepository;
	 }
	
	
	@GetMapping
	public List<Student> getStudents() {
       return studentRepository.findAll();
    }


	@PostMapping
	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("Email Taken");
		}
		studentRepository.save(student);
	}
	
	@DeleteMapping
	public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("student with id " + studentId + "does not exist"));
		if (name != null && name.length()>0 && !Objects.equals(student.getName(),name)) {
			student.setName(name);
		}
		if (email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("Email is taken");
			}
			student.setEmail(email);
		}
		
	}

}
