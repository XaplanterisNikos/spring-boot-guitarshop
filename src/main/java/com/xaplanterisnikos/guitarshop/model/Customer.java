package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Model class representing a customer entity.
 */

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {


    /**
     * The unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    /**
     * The name of the customer.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the customer.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * The email of the customer.
     */
    @Column(name = "email")
    private String email;
}
