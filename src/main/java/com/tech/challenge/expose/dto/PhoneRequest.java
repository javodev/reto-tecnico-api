package com.tech.challenge.expose.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class PhoneRequest {

    @NotEmpty(message = "El número de teléfono no puede estar vacío")
    @Pattern(regexp = "^[0-9]{7,15}$", message = "El número de teléfono debe tener entre 7 y 15 dígitos")
    private String number;

    @NotEmpty(message = "El código de ciudad no puede estar vacío")
    @Pattern(regexp = "^[0-9]{1,5}$", message = "El código de ciudad debe ser un número de entre 1 y 5 dígitos")
    private String citycode;

    @NotEmpty(message = "El código de país no puede estar vacío")
    @Pattern(regexp = "^[0-9]{1,5}$", message = "El código de país debe ser un número de entre 1 y 5 dígitos")
    private String countrycode;
}
