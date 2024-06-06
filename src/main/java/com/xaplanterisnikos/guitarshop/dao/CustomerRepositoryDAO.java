package com.xaplanterisnikos.guitarshop.dao;

import com.xaplanterisnikos.guitarshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Data Access Object (DAO) for managing {@link Customer} entities.
 * This interface extends {@link JpaRepository} to provide CRUD operations for {@link Customer} entities.
 *
 * <p>
 * JpaRepository provides various methods for working with Customer persistence,
 * including methods for saving, deleting, and finding Customer entities.
 * </p>
 */
public interface CustomerRepositoryDAO extends JpaRepository<Customer, Long> {
}
