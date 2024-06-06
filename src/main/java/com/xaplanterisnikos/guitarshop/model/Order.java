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
     * Represents the relationship between an order and a customer.
     * This is a many-to-one relationship where many orders can belong to one customer.
     *
     * <p>
     * Annotations used:
     * <ul>
     *   <li>{@code @ManyToOne}: Specifies that this entity has a many-to-one relationship with the {@link Customer} entity.</li>
     *   <li>{@code @JoinColumn(name = "customer_id")}: Specifies the foreign key column ({@code customer_id}) in the orders table that references the primary key of the {@link Customer} entity.</li>
     * </ul>
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    /**
     * Represents the relationship between an order and its shipping address.
     * This is a one-to-one relationship where an order has one shipping address.
     *
     * <p>
     * Annotations used:
     * <ul>
     *   <li>{@code @OneToOne(cascade = CascadeType.ALL)}: Specifies that this entity has a one-to-one relationship with the {@link Address} entity.
     *       CascadeType.ALL means all operations (persist, merge, remove, refresh, detach) should be cascaded to the {@link Address} entity.</li>
     *   <li>{@code @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")}: Specifies the foreign key column ({@code shipping_address_id}) in the orders table that references the {@code id} column in the {@link Address} entity.</li>
     * </ul>
     * </p>
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id",referencedColumnName = "id")
    private Address shippingAddress;

    /**
     * Represents the relationship between an order and its billing address.
     * This is a one-to-one relationship where an order has one billing address.
     *
     * <p>
     * Annotations used:
     * <ul>
     *   <li>{@code @OneToOne(cascade = CascadeType.ALL)}: Specifies that this entity has a one-to-one relationship with the {@link Address} entity.
     *       CascadeType.ALL means all operations (persist, merge, remove, refresh, detach) should be cascaded to the {@link Address} entity.</li>
     *   <li>{@code @JoinColumn(name = "billing_address_id", referencedColumnName = "id")}: Specifies the foreign key column ({@code billing_address_id}) in the orders table that references the {@code id} column in the {@link Address} entity.</li>
     * </ul>
     * </p>
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id",referencedColumnName = "id")
    private Address billingAddress;

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
