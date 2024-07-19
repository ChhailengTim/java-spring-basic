package com.example.customers.fruit;

import jakarta.persistence.*;

@Entity
public class FruitModel {

    @Id
    @SequenceGenerator(name = "fruit_sequence",
            sequenceName = "fruit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fruit_sequence"
    )
    private Long id;

    private String name;
    private Double price;

    // Constructors
    public FruitModel() {
    }

    public FruitModel(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
