package com.xaplanterisnikos.guitarshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object (DTO) representing a user.
 * This class encapsulates user information including ID, first name, last name, login, and token.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    /**
     * The unique identifier for the user.
     */
    private Long id;

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The login username of the user.
     */
    private String login;

    /**
     * The authentication token associated with the user.
     */
    private String token;

}
