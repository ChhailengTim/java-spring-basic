package com.lengcode;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public ResponseGreet greet(){
        ResponseGreet response = new ResponseGreet("hello",
                List.of("Java","Golang","JavaScript"),
                new Person("Alex",25,30000)
                );
        return response;
    }

    record Person (String name, int age, double saving) {

    }

    record ResponseGreet(String greet, List<String> favProgrammingLanguage, Person person){}
}
