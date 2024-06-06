package com.xaplanterisnikos.guitarshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Model class representing a customer entity.
 */

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {


    /**
     * The unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    /**
     * The name of the customer.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the customer.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * The email of the customer.
     */
    @Column(name = "email")
    private String email;

/**
 * Represents the relationship between a customer entity and a set of {@link Order} entities.
 * This is a one-to-many relationship where one customer can have multiple orders.
 */
 @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();


    /**
     * Adds an {@link Order} to the set of orders associated with this customer.
     * If the order is not already present in the set, it will be added.
     * If the set of orders does not already contain the given order,
     * a new {@link HashSet} is created, and the order is added to this new set.
     * </p>
     *
     * @param order the {@link Order} to be added to the set of orders. If the order is {@code null}, no action is taken.
     */
 public void add(Order order){
     if (order != null) {

         if (!orders.contains(order)) {
             orders = new HashSet<>();
         }
         orders.add(order);
         order.setCustomer(this);
     }
 }
}
