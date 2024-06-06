package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.util.Date;

/***
 * Model
 * Entity Product
 * Represents a product in the guitar shop application.
 * JoinColumn ManyToOne with category
 */

@Entity
@Table(name="product")
@Data
public class Product {

    /**
     * The unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The stock keeping unit (SKU) of the product.
     */
    @Column(name = "sku")
    private String sku;

    /**
     * The name of the product.
     */
    @Column(name = "name")
    private String name;

    /**
     * The description of the product.
     */
    @Column(name = "description")
    private String description;

    /**
     * The unit price of the product.
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    /**
     * The URL of the product image.
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * Indicates whether the product is active or not.
     */
    @Column(name = "active")
    private boolean active;

    /**
     * The number of units in stock for the product.
     */
    @Column(name = "units_in_stock")
    private int unitsInStock;

    /**
     * The date when the product was created.
     */
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    /**
     * The date when the product was last updated.
     */
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    /**
     * The category to which the product belongs.
     */
    @ManyToOne
    @JoinColumn(name="category_id",nullable=false)
    private ProductCategory category;


}
