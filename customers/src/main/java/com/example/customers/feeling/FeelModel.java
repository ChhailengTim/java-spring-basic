package com.example.customers.feeling;

import jakarta.persistence.*;

@Entity
public class FeelModel {

    @Id
    @SequenceGenerator(name = "feel_sequence",
            sequenceName = "feel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feel_sequence"
    )
    private Long id;
    private String mood;

    // No-argument constructor for JPA
    public FeelModel() {
    }

    // Parameterized constructor for easy instantiation
    public FeelModel(Long id, String mood) {
        this.id = id;
        this.mood = mood;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "FeelModel{" +
                "id=" + id +
                ", mood='" + mood + '\'' +
                '}';
    }
}
