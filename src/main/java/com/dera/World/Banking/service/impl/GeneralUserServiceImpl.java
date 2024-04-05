package com.dera.World.Banking.service.impl;

import com.dera.World.Banking.domain.entities.UserEntity;
import com.dera.World.Banking.infrastructure.config.JwtAuthenticationFilter;
import com.dera.World.Banking.infrastructure.config.JwtTokenProvider;
import com.dera.World.Banking.payload.response.BankResponse;
import com.dera.World.Banking.repository.UserRepository;
import com.dera.World.Banking.service.GeneralUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneralUserServiceImpl implements GeneralUserService {
    private final FileUploadServiceImpl fileUploadService;
    private final UserRepository userRepository;
    private final JwtAuthenticationFilter authenticationFilter;
    private final HttpServletRequest request;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<BankResponse<String>> uploadProfilePics(MultipartFile profilePics) {
        String token = authenticationFilter.getTokenFromRequest(request);
        String email = jwtTokenProvider.getUserName(token);

        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);

        String fileUrl = null;

        try {
            if (userEntityOptional.isPresent()){
                fileUrl = fileUploadService.uploadFile(profilePics);

                UserEntity userEntity = userEntityOptional.get();
                userEntity.setProfilePicture(fileUrl);

                userRepository.save(userEntity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(
                new BankResponse<>(
                        "Uploaded Successfully",
                        fileUrl
                )
        );
    }
}
