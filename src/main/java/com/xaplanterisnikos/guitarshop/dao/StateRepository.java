package com.xaplanterisnikos.guitarshop.dao;

import com.xaplanterisnikos.guitarshop.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Repository interface for managing states in the guitar shop application.
 */
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {

    /**
     * Retrieves a list of states associated with a given country code.
     *
     * @param code The code of the country.
     * @return A list of states associated with the specified country code.
     */
    List<State> findByCountryCode(@Param("code")String code);

}
