package com.xaplanterisnikos.guitarshop.controller;


import com.xaplanterisnikos.guitarshop.config.UserAuthenticationProvider;
import com.xaplanterisnikos.guitarshop.dto.CredentialsDto;
import com.xaplanterisnikos.guitarshop.dto.SignUpDTO;
import com.xaplanterisnikos.guitarshop.dto.UserDTO;
import com.xaplanterisnikos.guitarshop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * REST controller for handling authentication-related requests.
 */
//@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    /**
     * Handles login requests.
     * Authenticates the user with the provided credentials and returns the user's details along with a JWT token.
     *
     * @param credentialsDto the user's login credentials
     * @return the authenticated user's details with a JWT token
     */
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDTO userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    /**
     * Handles registration requests.
     * Registers a new user and returns the user's details along with a JWT token.
     *
     * @param user the user's registration details
     * @return the registered user's details with a JWT token
     */
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid SignUpDTO user) {
        UserDTO createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}
