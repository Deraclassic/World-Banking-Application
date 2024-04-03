package com.dera.World.Banking.infrastructure.controller;

import com.dera.World.Banking.payload.request.UserRequest;
import com.dera.World.Banking.payload.response.BankResponse;
import com.dera.World.Banking.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
@Tag(name = "User Authentication Management APIs")
public class AuthController {
    private final AuthService authService;
    @Operation(
            summary = "Register New User Account",
            description = "Create a new user and assign account number"
    )
    @PostMapping("register-user")
    public BankResponse createAccount(@Valid @RequestBody UserRequest userRequest){
        return authService.registerUser(userRequest);
    }

}
