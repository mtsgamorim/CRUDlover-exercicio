package com.carsapi.api.dto;

import java.util.Date;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarDTO(

    @NotBlank
    String modelo, 

    @NotBlank
    String fabricante, 

    @Past
    Date dataFabricacao, 

    @NotNull
    double valor, 

    @NotNull
    @DecimalMax(value = "2023")
    @DecimalMin(value = "1000")
    int anoModelo) {
    
}
