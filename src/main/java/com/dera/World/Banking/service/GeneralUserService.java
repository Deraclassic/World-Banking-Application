package com.dera.World.Banking.service;

import com.dera.World.Banking.payload.response.BankResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface GeneralUserService {
    ResponseEntity<BankResponse<String>> uploadProfilePics(MultipartFile multipartFile);
}
