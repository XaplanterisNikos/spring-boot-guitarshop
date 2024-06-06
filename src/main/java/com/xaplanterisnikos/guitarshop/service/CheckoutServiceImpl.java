package com.xaplanterisnikos.guitarshop.service;

import com.xaplanterisnikos.guitarshop.dao.CustomerRepositoryDAO;
import com.xaplanterisnikos.guitarshop.dto.PurchaseDTO;
import com.xaplanterisnikos.guitarshop.dto.PurchaseResponseDTO;
import com.xaplanterisnikos.guitarshop.model.Customer;
import com.xaplanterisnikos.guitarshop.model.Order;
import com.xaplanterisnikos.guitarshop.model.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


/**
 * Service implementation for handling checkout operations in the guitar shop.
 * This service provides the logic for placing an order based on the provided purchase details.
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepositoryDAO customerRepositoryDAO;

    /**
     * Constructs a new CheckoutServiceImpl with the specified CustomerRepositoryDAO.
     *
     * @param customerRepositoryDAO the data access object for managing Customer entities.
     */
    public CheckoutServiceImpl(CustomerRepositoryDAO customerRepositoryDAO) {
        this.customerRepositoryDAO = customerRepositoryDAO;
    }

    /**
     * Places an order based on the given purchase details.
     *
     * @param purchaseDTO the {@link PurchaseDTO} containing all necessary purchase information including customer, order, and addresses.
     * @return a {@link PurchaseResponseDTO} containing the order tracking number.
     */
    @Override
    @Transactional
    public PurchaseResponseDTO placeOrder(PurchaseDTO purchaseDTO) {

        // retrieve the order info from dto
        Order order = purchaseDTO.getOrder();
        // generate tracking number

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchaseDTO.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchaseDTO.getBillingAddress());
        order.setShippingAddress(purchaseDTO.getShippingAddress());

        // populate customer with order
        Customer customer = purchaseDTO.getCustomer();
        customer.add(order);

        // save to the database
        customerRepositoryDAO.save(customer);

        // return a response
        return new PurchaseResponseDTO(orderTrackingNumber);

    }

    /**
     * Generates a unique order tracking number.
     *
     * <p>
     * This method generates a random UUID (Universally Unique IDentifier) Version 4, which is a unique identifier
     * that is highly unlikely to be duplicated. The generated tracking number is returned as a string.
     * </p>
     *
     * @return a unique order tracking number as a string.
     */
    private String generateOrderTrackingNumber() {
        // generate a random Number UUID (Universally Unique IDentifier) Version 4
        return UUID.randomUUID().toString();
    }
}
