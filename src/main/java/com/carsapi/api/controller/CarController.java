package com.carsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.api.dto.CarDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.repository.CarRepository;

import jakarta.validation.Valid;

@RequestMapping("/")
@RestController
public class CarController {

    @Autowired
    private CarRepository repository;


    @GetMapping
    public List<Car> listAll() {
        return repository.findAll();
    }
    
    @PostMapping
    public void createCar(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));
        System.out.println(req.modelo());
        System.out.println(req.fabricante());
        System.out.println(req.dataFabricacao());
        System.out.println(req.valor());
        System.out.println(req.anoModelo());
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
        repository.findById(id).map(car -> {
            car.setAnoModelo(req.anoModelo());
            car.setDataFabricacao(req.dataFabricacao());
            car.setFabricante(req.fabricante());
            car.setModelo(req.modelo());
            car.setValor(req.valor());

            return repository.save(car);
        });
    }
}
