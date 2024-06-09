package com.xaplanterisnikos.guitarshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
/**
 * Configuration class for setting up password encoding.
 */
@Component
public class PasswordConfig {
    /**
     * Creates a bean for the PasswordEncoder that uses BCrypt hashing algorithm.
     *
     * @return a PasswordEncoder instance using BCrypt
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
