package com.xaplanterisnikos.guitarshop.dto;

/**
 * A data transfer object (DTO) representing user sign-up information.
 * This record encapsulates the user's first name, last name, login, and password.
 */
public record SignUpDTO(String firstName, String lastName, String login, char[] password) { }
