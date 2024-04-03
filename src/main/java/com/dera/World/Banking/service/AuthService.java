package com.dera.World.Banking.service;

import com.dera.World.Banking.payload.request.UserRequest;
import com.dera.World.Banking.payload.response.BankResponse;

public interface AuthService {
    BankResponse registerUser(UserRequest userRequest);
}
