package com.dera.World.Banking.service;

import com.dera.World.Banking.payload.request.LoginRequest;
import com.dera.World.Banking.payload.request.UserRequest;
import com.dera.World.Banking.payload.response.APIResponse;
import com.dera.World.Banking.payload.response.BankResponse;
import com.dera.World.Banking.payload.response.JwtAuthResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    BankResponse registerUser(UserRequest userRequest);

    ResponseEntity<APIResponse<JwtAuthResponse>> login(LoginRequest loginRequest);
}
