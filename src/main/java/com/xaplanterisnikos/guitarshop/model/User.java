package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
//import jakarta.validation.constraints.Size;
import lombok.*;


/**
 * Represents a user entity in the application.
 * This class defines the structure of a user, including their ID, first name, last name, login, and password.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "app_user")
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the user.
     */
    @Column(name = "first_name", nullable = false)
    //@Size(max = 100)
    private String firstName;

    /**
     * The last name of the user.
     */
    @Column(name = "last_name", nullable = false)
    //@Size(max = 100)
    private String lastName;

    /**
     * The login username of the user.
     */
    @Column(nullable = false)
    //@Size(max = 100)
    private String login;

    /**
     * The password of the user.
     */
    @Column(nullable = false)
   // @Size(max = 100)
    private String password;

    /**
     * Retrieves the ID of the user.
     *
     * @return the user ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the user ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the user.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the login username of the user.
     *
     * @return the login username
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login username of the user.
     *
     * @param login the login username to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
