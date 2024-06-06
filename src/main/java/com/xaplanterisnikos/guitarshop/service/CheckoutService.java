package com.xaplanterisnikos.guitarshop.service;

import com.xaplanterisnikos.guitarshop.dto.PurchaseDTO;
import com.xaplanterisnikos.guitarshop.dto.PurchaseResponseDTO;

/**
 * Service interface for handling checkout operations in the guitar shop.
 * This service defines the contract for placing an order based on the provided purchase details.
 */
public interface CheckoutService {

    /**
     * Places an order based on the given purchase details.
     *
     * @param purchaseDTO the {@link PurchaseDTO} containing all necessary purchase information including customer, order, and addresses.
     * @return a {@link PurchaseResponseDTO} containing the order tracking number.
     */
    PurchaseResponseDTO placeOrder(PurchaseDTO purchaseDTO);
}
