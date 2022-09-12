package com.example.laptopsrestdatajpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel("Laptop entity")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Auto-incremental Long type key")
    private Long id;
    private String brand;
    private String model;
    @ApiModelProperty("EUR")
    private Double price;
    @ApiModelProperty("GB")
    private Integer memory;
    private Boolean isSSD;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, Double price, Integer memory, Boolean isSSD) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.memory = memory;
        this.isSSD = isSSD;
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
        return isSSD;
    }

    public void setSDD(Boolean SDD) {
        isSSD = SDD;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", memory=" + memory +
                ", isSDD=" + isSSD +
                '}';
    }
}
