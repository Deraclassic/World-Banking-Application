package com.dera.World.Banking.service.impl;

import com.dera.World.Banking.domain.entities.UserEntity;
import com.dera.World.Banking.payload.request.EmailDetails;
import com.dera.World.Banking.payload.request.UserRequest;
import com.dera.World.Banking.payload.response.AccountInfo;
import com.dera.World.Banking.payload.response.BankResponse;
import com.dera.World.Banking.repository.UserRepository;
import com.dera.World.Banking.service.AuthService;
import com.dera.World.Banking.service.EmailService;
import com.dera.World.Banking.utils.AccountUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    @Override
    public BankResponse registerUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        UserEntity newUser = UserEntity.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .middleName(userRequest.getMiddleName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .status(userRequest.getAddress())
                .address(userRequest.getAddress())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .status("ACTIVE")
                .profilePicture("https://res.cloudinary.com/dpfqbb9pl/image/upload/v1701260428/maleprofile_ffeep9.png")
                .build();

        UserEntity saveUser = userRepository.save(newUser);

        //send email alert
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(saveUser.getEmail())
                .subject("ACCOUNT CREATION")
                .messageBody("CONGRATULATIONS!!! Your Account Has Been Successfully Created. \n Your account details: \n" +
                        "Account Name: " + saveUser.getFirstName() + " " + saveUser.getMiddleName() + " " + saveUser.getLastName() +
                        "\nAccount Number: " + saveUser.getAccountNumber())
                .build();
        emailService.sendEmailAlert(emailDetails);

        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_SUCCESS_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountNumber(saveUser.getAccountNumber())
                        .accountBalance(saveUser.getAccountBalance())
                        .accountName(saveUser.getFirstName() + " " +
                                saveUser.getLastName() + " " +
                                saveUser.getMiddleName())
                        .build())
                .build();
    }
}
