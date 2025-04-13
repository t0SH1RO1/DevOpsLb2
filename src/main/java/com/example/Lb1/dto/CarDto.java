package com.example.Lb1.dto;

import org.springframework.lang.NonNull;

public record CarDto(@NonNull String id, @NonNull String make, @NonNull String model, String year) {}