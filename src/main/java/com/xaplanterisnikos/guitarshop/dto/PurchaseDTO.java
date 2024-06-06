package com.xaplanterisnikos.guitarshop.dto;

import com.xaplanterisnikos.guitarshop.model.Address;
import com.xaplanterisnikos.guitarshop.model.Customer;
import com.xaplanterisnikos.guitarshop.model.Order;
import com.xaplanterisnikos.guitarshop.model.OrderItem;
import lombok.Data;

import java.util.Set;


/**
 * Data Transfer Object (DTO) for transferring purchase information.
 * This class aggregates all the necessary details for a purchase transaction,
 * including customer information, shipping and billing addresses, order details,
 * and the items in the order.
 *
 * <p>
 * Annotations:
 * <ul>
 *   <li>{@code @Data}: A Lombok annotation that generates boilerplate code such as getters, setters, toString, equals, and hashCode methods.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Fields:
 * <ul>
 *   <li>{@code customer}: The customer placing the order. An instance of {@link Customer}.</li>
 *   <li>{@code shippingAddress}: The shipping address for the order. An instance of {@link Address}.</li>
 *   <li>{@code billingAddress}: The billing address for the order. An instance of {@link Address}.</li>
 *   <li>{@code order}: The order details. An instance of {@link Order}.</li>
 *   <li>{@code orderItems}: The items included in the order. A set of {@link OrderItem} instances.</li>
 * </ul>
 * </p>
 */
@Data
public class PurchaseDTO {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
