package com.xaplanterisnikos.guitarshop.dao;

import com.xaplanterisnikos.guitarshop.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//import java.util.List;

/**
 * Repository interface for managing Order entities.
 */
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Finds orders by the customer's ID with pagination support.
     *
     * @param id       the ID of the customer
     * @param pageable the pagination information
     * @return a page of orders associated with the specified customer ID
     */
    Page<Order> findByCustomerId(@Param("id")Long id, Pageable pageable);

    /**
     * Finds orders by the customer's email with pagination support.
     *
     * @param email    the email of the customer
     * @param pageable the pagination information
     * @return a page of orders associated with the specified customer email
     */
    Page<Order> findByCustomerEmail(@Param("email")String email, Pageable pageable);


}
