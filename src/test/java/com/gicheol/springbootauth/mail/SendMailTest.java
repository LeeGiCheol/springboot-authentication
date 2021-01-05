package com.gicheol.springbootauth.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class SendMailTest {

    @Autowired
    AuthNumberSendMail authNumberSendMail;

    @Test
    void sendMail() throws MessagingException {
        authNumberSendMail.sendMail("email");
    }
}