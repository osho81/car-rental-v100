package com.osho.twCarRental.controller;

import com.osho.twCarRental.model.Car;
import com.osho.twCarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class CarController {

    @Autowired
    private CarService carService;

    // "Lista tillgängliga bilar GET /api/v1/cars"
    @GetMapping("/cars") // USER ROLE REQUIRED
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<List<Car>>(carService.getAllCars(), HttpStatus.OK);
    }

    // "Lägga till fordon POST /api/v1/addcar"
    @PostMapping("/addcar") // ADMIN ROLE REQUIRED
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return new ResponseEntity<Car>(carService.addCar(car), HttpStatus.CREATED);
    }

    // "Uppdatera fordon PUT /api/v1/updatecar"
    @PutMapping("/updatecar") // ADMIN ROLE REQUIRED
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return new ResponseEntity<Car>(carService.updateCar(car), HttpStatus.CREATED);
    }

    // "Ta bort fordon DELETE /api/v1/deletecar"
    @DeleteMapping("/deletecar") // ADMIN ROLE REQUIRED
    public ResponseEntity<String> deleteCar(@RequestBody Car car) {
        carService.deleteCar(car);
        return new ResponseEntity<String>("Car with reg. nr " + car.getRegNr() + " deleted.", HttpStatus.OK);
    }

}
