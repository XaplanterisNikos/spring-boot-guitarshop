package com.xaplanterisnikos.guitarshop.dao;

import com.xaplanterisnikos.guitarshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository interface for managing Customer entities.
 * This interface extends JpaRepository to provide CRUD operations for Customer entities.
 */
public interface CustomerRepositoryDAO extends JpaRepository<Customer, Long> {
}
