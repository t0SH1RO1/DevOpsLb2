package com.example.Lb1.utils;

import com.example.Lb1.model.Car;
import com.example.Lb1.dto.CarDto;

import java.util.UUID;

public class TransferDataUtils {

    public static Car carDtoToEntity(CarDto carDto) {
        String id = carDto.id();
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Car ID cannot be null or empty");
        }
        return new Car(carDto.make(), carDto.model(), carDto.year());
    }

    public static CarDto carEntityToDto(Car car) {
        return new CarDto(car.getId().toString(), car.getMake(), car.getModel(), car.getYear());
    }
}