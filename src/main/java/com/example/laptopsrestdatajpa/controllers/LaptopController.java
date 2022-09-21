package com.example.laptopsrestdatajpa.controllers;

import com.example.laptopsrestdatajpa.entities.Laptop;
import com.example.laptopsrestdatajpa.repositories.LaptopRepository;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    //Logger method for warning and info messages
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //Attribute
    private LaptopRepository laptopRepository;

    //CRUD methods
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //1. Getting laptops, all at once and one by id
    @GetMapping ("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @GetMapping ("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@ApiParam ("Clave primaria tipo Long") @PathVariable Long id) {
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);
        if(laptopOptional.isPresent())
            return ResponseEntity.ok(laptopOptional.get());
        else return ResponseEntity.notFound().build();
    }

    //2. Creating a new laptop
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create (@RequestBody Laptop laptop){
        if(laptop.getId() != null){
            log.warn("Trying to create a laptop giving an id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //3. Updating existing laptops in database
    @PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> update (@PathVariable ("id") @RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("Trying to update a nonexistent laptop");
            return ResponseEntity.badRequest().build();
        }if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a nonexistent laptop");
            return ResponseEntity.notFound().build();
        }

        //When no ifs exist, process success

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //4. Deleting one or all laptops
    @DeleteMapping("api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a nonexistent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    //When adding @ApiIgnore right before methods, we avoid them to appear in Swagger documentation
}
