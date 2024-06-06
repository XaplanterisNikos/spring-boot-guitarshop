package com.xaplanterisnikos.guitarshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Represents a country entity in the guitar shop application.
 */
@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {

    /**
     * The unique identifier for the country.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * The code of the country.
     */
    @Column(name = "code")
    private String code;

    /**
     * The name of the country.
     */
    @Column(name = "name")
    private String name;

    /**
     * The list of states associated with this country.
     */
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> states;
}
