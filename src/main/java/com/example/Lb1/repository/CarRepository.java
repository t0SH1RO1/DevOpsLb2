package com.example.Lb1.repository;

import com.example.Lb1.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    List<Car> findAll();

    Car findFirstByMakeContaining(String make);
}