package com.tech.challenge.expose.controller;

import com.tech.challenge.business.UserService;
import com.tech.challenge.expose.dto.UserDetailResponse;
import com.tech.challenge.expose.dto.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/challenge/v1")
@Slf4j
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Proceso Satisfactorio."),
            @ApiResponse(responseCode = "400", description = "El cliente envia datos incorrectos.",
                    content = @Content(schema = @Schema(implementation = Exception.class))) },
            summary = "Crear clientes", method = "POST"
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest) {
        return this.userService.createUser(userRequest);
    }

}
