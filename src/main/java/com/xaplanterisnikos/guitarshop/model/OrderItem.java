package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Model class representing an order Item.
 */
@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {

    /**
     * The unique identifier for the item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The url image of the item.
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * The unit price of the item.
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    /**
     * The quantity of the item.
     */
    @Column(name = "quantity")
    private int quantity;

    /**
     * The product ID of the item.
     */
    @Column(name = "product_id")
    private Long productId;

/**
 * Represents the relationship between an entity and an {@link Order}.
 * This is a many-to-one relationship where many instances of the current entity
 * are associated with one {@link Order}.
 **/
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
