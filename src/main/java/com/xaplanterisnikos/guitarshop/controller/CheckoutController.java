package com.xaplanterisnikos.guitarshop.controller;

import com.xaplanterisnikos.guitarshop.dto.PurchaseDTO;
import com.xaplanterisnikos.guitarshop.dto.PurchaseResponseDTO;
import com.xaplanterisnikos.guitarshop.service.CheckoutService;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for handling checkout-related HTTP requests in the guitar shop API.
 * This controller provides endpoints for placing orders and handling purchase transactions.
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    /**
     * Constructs a new CheckoutController with the specified CheckoutService.
     *
     * @param checkoutService the service responsible for checkout operations.
     */
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    /**
     * Endpoint for placing an order.
     *
     * @param purchaseDTO the {@link PurchaseDTO} containing all necessary purchase information including customer, order, and addresses.
     * @return a {@link PurchaseResponseDTO} containing the order tracking number.
     */
    @PostMapping("/purchase")
    public PurchaseResponseDTO placeOrder(@RequestBody PurchaseDTO purchaseDTO) {
        PurchaseResponseDTO purchaseResponseDTO = checkoutService.placeOrder(purchaseDTO);
        return purchaseResponseDTO;
    }

}
