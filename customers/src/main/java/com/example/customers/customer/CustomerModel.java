package com.example.customers.customer;

import jakarta.persistence.*;

@Entity
@Table
public class CustomerModel {

    @Id@SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    // No-argument constructor for JPA
    public CustomerModel() {
    }

    // Parameterized constructor for easy instantiation
    public CustomerModel( String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
