package com.gicheol.springbootauth.domain;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void signUp() {
        String id = "ekkkk1";
        String password = "ekkkk1";
        String phone = "010-1234-5678";
        String email = "leegicheolgc@gmail.com";

        userRepository.save(User.builder()
                .id(id)
                .password(password)
                .phone(phone)
                .email(email)
                .build());

        Optional <User> userList = userRepository.findById(id);
        User user = userList.get();
        assertEquals(email, user.getEmail());
    }

}