package com.xaplanterisnikos.guitarshop.repositories;


import com.xaplanterisnikos.guitarshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing User entities.
 * This interface extends JpaRepository to provide CRUD operations for User entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieves an optional User entity by its login username.
     *
     * @param login the login username to search for
     * @return an Optional containing the User entity if found, or an empty Optional otherwise
     */
    Optional<User> findByLogin(String login);
}
