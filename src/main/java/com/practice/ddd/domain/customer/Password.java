package com.practice.ddd.domain.customer;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

    private String password;

    public Password(String rawPassword) {
        this.password = encrypt(rawPassword);
    }

    private String encrypt(String rawPassword) {
        return new StringBuilder(rawPassword).reverse().toString();
    }

    public boolean matches(String rawPassword) {
        return encrypt(rawPassword).equals(this.password);
    }

    public String getPassword() {
        return this.password;
    }

}
