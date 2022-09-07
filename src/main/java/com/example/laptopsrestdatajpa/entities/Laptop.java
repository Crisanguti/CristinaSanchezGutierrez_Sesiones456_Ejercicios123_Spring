package com.example.laptopsrestdatajpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Double price;
    private Integer memory;
    private Boolean isSDD;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, Double price, Integer memory, Boolean isSDD) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.memory = memory;
        this.isSDD = isSDD;
    }

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Boolean getSDD() {
        return isSDD;
    }

    public void setSDD(Boolean SDD) {
        isSDD = SDD;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", memory=" + memory +
                ", isSDD=" + isSDD +
                '}';
    }
}
