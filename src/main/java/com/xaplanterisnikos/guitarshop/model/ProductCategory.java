package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

/**
 * Model
 * Entity Product category
 * Represents a category of products in the guitar shop application.
 * OneToMany Product Array
 */
@Entity
@Table(name="product_category")
@Getter
@Setter
public class ProductCategory {

    /**
     * The unique identifier for the product category.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the product category.
     */
    @Column(name="category_name")
    private String categoryName;

    /**
     * The set of products belonging to this category.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;
}
