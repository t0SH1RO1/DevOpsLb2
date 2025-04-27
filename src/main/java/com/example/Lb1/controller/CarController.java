package com.example.Lb1.controller;

import com.example.Lb1.dto.CarDto;
import com.example.Lb1.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("car", new CarDto("", "", "", ""));
        return "car_form";
    }

    @PostMapping("/add")
    public String submitCar(@ModelAttribute CarDto carDto) {
        if (carDto.id() == null || carDto.id().isEmpty()) {
            carDto = new CarDto(UUID.randomUUID().toString(), carDto.make(), carDto.model(), carDto.year());
        }
        carService.saveCar(carDto);
        return "redirect:/cars/list";
    }

    @GetMapping("/list")
    public String getAllCars(Model model) {
        List<CarDto> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "car_list";
    }

    @PostMapping("/clearDatabase")
    public String clearDatabase() {
        carService.clearDatabase();
        return "redirect:/cars/list";
    }
}