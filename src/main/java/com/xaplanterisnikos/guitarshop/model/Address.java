package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * Model class representing an address entity.
 */
@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    /**
     * The unique identifier for the address.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the street.
     */
    @Column(name = "street")
    private String street;

    /**
     * The name of the city.
     */
    @Column(name = "city")
    private String city;

    /**
     * The name of the state.
     */
    @Column(name = "state")
    private String state;

    /**
     * The name of the country.
     */
    @Column(name = "country")
    private String country;

    /**
     * The zipCode of the country.
     */
    @Column(name = "zip_code")
    private String zipCode;




}
