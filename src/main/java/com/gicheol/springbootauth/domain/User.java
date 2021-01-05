package com.gicheol.springbootauth.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private String id;

    private String password;
    private String phone;
    private String email;

    @Builder
    public User(String id, String password, String phone, String email) {
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public User() {

    }
}
