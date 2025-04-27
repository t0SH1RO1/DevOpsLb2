package com.example.Lb1.service;

import com.example.Lb1.dto.CarDto;
import com.example.Lb1.model.Car;
import com.example.Lb1.repository.CarRepository;
import com.example.Lb1.utils.TransferDataUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(CarDto carDto) {
        carRepository.save(TransferDataUtils.carDtoToEntity(carDto));
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(TransferDataUtils::carEntityToDto)
                .toList();
    }

    public void clearDatabase() {
        carRepository.deleteAll();
    }
}