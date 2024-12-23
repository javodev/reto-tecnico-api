package com.tech.challenge.expose.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties
public class UserRequest {

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;

    @NotEmpty(message = "El correo no puede estar vacío")
    //@Email(message = "El correo debe ser válido")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "El correo debe ser válido")
    private String email;

    @NotEmpty(message = "La contraseña no puede estar vacía")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "La contraseña debe contener al menos 8 caracteres, con letras y números")
    private String password;

    private List<PhoneRequest> phones;
}
