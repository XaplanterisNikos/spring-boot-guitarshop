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


    /**
     * Represents the relationship between this entity and an {@link Order}.
     * This is a one-to-one relationship where this entity has the same primary key as the associated {@link Order}.
     *
     * <p>
     * Annotations used:
     * <ul>
     *   <li>{@code @OneToOne}: Specifies that this entity has a one-to-one relationship with the {@link Order} entity.</li>
     *   <li>{@code @PrimaryKeyJoinColumn}: Specifies that the primary key of this entity is also the primary key of the associated {@link Order} entity.</li>
     * </ul>
     * </p>
     */
    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;




}
