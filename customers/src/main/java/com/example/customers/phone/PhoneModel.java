package com.example.customers.phone;

import jakarta.persistence.*;

@Entity
public class PhoneModel {

    @Id
    @SequenceGenerator(name = "phone_sequence",
            sequenceName = "phone_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "phone_sequence"
    )
    private Long id;
    private String brand;
    private int year;
    private String model;
    private double price;

    // No-argument constructor
    public PhoneModel() {}

    // All-argument constructor
    public PhoneModel(Long id, String brand, int year, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.model = model;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PhoneModel{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
