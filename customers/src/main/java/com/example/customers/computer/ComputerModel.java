package com.example.customers.computer;


import jakarta.persistence.*;

@Entity
public class ComputerModel {

    @Id
    @SequenceGenerator(name = "computer_sequence",
            sequenceName = "computer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "computer_sequence"
    )
    private Long id;
    private String model;
    private String brand;
    private int year;
    private double price;

    // No-argument constructor for JPA
    public ComputerModel() {
    }

    // Parameterized constructor for easy instantiation
    public ComputerModel(Long id, String model, String brand, int year, double price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComputerModel{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
