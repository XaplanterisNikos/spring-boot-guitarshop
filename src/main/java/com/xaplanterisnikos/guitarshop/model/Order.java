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
     * The customer associated with the order.
     */
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    /**
     * The shipping address for the order.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id",referencedColumnName = "id")
    private Address shippingAddress;

    /**
     * The billing address for the order.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id",referencedColumnName = "id")
    private Address billingAddress;

    /**
     * Adds an order item to the order.
     * If the provided order item is not null and not already present in the set of order items,
     * it is added to the set, and the order reference is set on the order item.
     *
     * @param item the OrderItem to add
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

    /**
     * Retrieves the order tracking number.
     * This method constructs and returns a tracking number string based on the order's unique identifier
     * and the last name and first name of the associated customer.
     *
     * @return the order tracking number
     */
    public String getOrderTrackingNumber(){
        return "Tracking No: "+orderTrackingNumber +" "+"CustomerName: "+ customer.getLastName() +" "+ customer.getFirstName();
    }

}
