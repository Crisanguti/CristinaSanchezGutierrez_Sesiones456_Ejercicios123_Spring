package com.example.laptopsrestdatajpa.repositories;

import com.example.laptopsrestdatajpa.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository <Laptop, Long> {
}
