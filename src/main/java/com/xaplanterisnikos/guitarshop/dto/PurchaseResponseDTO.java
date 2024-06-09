package com.xaplanterisnikos.guitarshop.dto;

import lombok.Data;


/**
 * Data transfer object (DTO) representing a response to a purchase request.
 * This class encapsulates the order tracking number generated for the purchase.
 */
@Data
public class PurchaseResponseDTO {
    /**
     * The order tracking number generated for the purchase.
     */
    private final String orderTrackingNumber;

}
