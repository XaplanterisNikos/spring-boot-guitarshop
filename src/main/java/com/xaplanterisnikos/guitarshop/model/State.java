package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents a state entity in the guitar shop application.
 */
@Entity
@Table(name = "state")
@Data
public class State {

    /**
     * The unique identifier for the state.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * The name of the state.
     */
    @Column(name = "name")
    private String name;

    /**
     * The country to which the state belongs.
     */
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
