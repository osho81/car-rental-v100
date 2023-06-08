package com.osho.carrental.service.repository;

import com.osho.carrental.model.Car;

import java.util.List;

public interface CarServiceRepository {

    List<Car> getAllCars();
    Car getCarById(String id); // Added 230608
    Car addCar(Car car);
    Car updateCar(Car car);
    void deleteCar(Car car);

}
