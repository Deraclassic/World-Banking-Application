package com.dera.World.Banking.service;

import com.dera.World.Banking.payload.request.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
