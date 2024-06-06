package com.xaplanterisnikos.guitarshop.dto;

import lombok.Data;


/**
 * Data Transfer Object (DTO) for transferring purchase response information.
 * This class contains information that is returned after a purchase is completed,
 * specifically the order tracking number.
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
 *   <li>{@code orderTrackingNumber}: The tracking number of the order. This is used to track the status of the order.</li>
 * </ul>
 * </p>
 */
@Data
public class PurchaseResponseDTO {
    private final String orderTrackingNumber;

}
