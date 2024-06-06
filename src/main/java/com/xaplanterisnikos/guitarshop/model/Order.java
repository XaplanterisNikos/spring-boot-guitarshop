package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Model class representing an order entity.
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    /**
     * The unique identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The tracking number of the order.
     */
    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    /**
     * The total quantity of items in the order.
     */
    @Column(name = "total_quantity")
    private int totalQuantity;

    /**
     * The total price of the order.
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * The status of the order.
     */
    @Column(name = "status")
    private String status;

    /**
     * The date the order was created.
     */
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    /**
     * The date the order was last updated.
     */
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    /**
     * The set of order items associated with the order.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    /**
     * Method to add an order item to the order.
     *
     * @param item The order item to add.
     */
    public void add(OrderItem item) {
        // check if null or empty
        if(item != null) {
            if(orderItems.contains(item)) {
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }
}
