package com.xaplanterisnikos.guitarshop.dto;

import com.xaplanterisnikos.guitarshop.model.Address;
import com.xaplanterisnikos.guitarshop.model.Customer;
import com.xaplanterisnikos.guitarshop.model.Order;
import com.xaplanterisnikos.guitarshop.model.OrderItem;
import lombok.Data;

import java.util.Set;


/**
 * Data transfer object (DTO) representing a purchase.
 * This class encapsulates information about a customer, shipping and billing addresses,
 * an order, and a set of order items.
 */
@Data
public class PurchaseDTO {

    /**
     * The customer associated with the purchase.
     */
    private Customer customer;

    /**
     * The shipping address for the purchase.
     */
    private Address shippingAddress;

    /**
     * The billing address for the purchase.
     */
    private Address billingAddress;

    /**
     * The order associated with the purchase.
     */
    private Order order;

    /**
     * The set of order items included in the purchase.
     */
    private Set<OrderItem> orderItems;
}
