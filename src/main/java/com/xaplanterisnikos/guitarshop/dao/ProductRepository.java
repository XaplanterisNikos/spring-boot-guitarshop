package com.xaplanterisnikos.guitarshop.dao;

import com.xaplanterisnikos.guitarshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Repository interface for managing products in the guitar shop application.
 */
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Retrieves a page of products associated with a given category ID.
     *
     * @param id       The ID of the category.
     * @param pageable The pagination information.
     * @return A page of products associated with the specified category ID.
     */
    Page<Product> findByCategoryId(@Param("id") Long id , Pageable pageable);

    /**
     * Retrieves a page of products whose name contains the specified string.
     *
     * @param name     The name to search for.
     * @param pageable The pagination information.
     * @return A page of products whose name contains the specified string.
     */
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
}
