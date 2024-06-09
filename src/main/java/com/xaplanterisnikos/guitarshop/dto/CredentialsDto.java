package com.xaplanterisnikos.guitarshop.dto;

/**
 * A data transfer object (DTO) representing credentials for authentication.
 * This record encapsulates the user's login and password.
 */
public record CredentialsDto(String login, char[] password) { }