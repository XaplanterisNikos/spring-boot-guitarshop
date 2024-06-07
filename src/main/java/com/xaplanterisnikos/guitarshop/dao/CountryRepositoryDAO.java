package com.xaplanterisnikos.guitarshop.dao;

import com.xaplanterisnikos.guitarshop.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Repository interface for managing countries in the guitar shop application.
 */
//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepositoryDAO extends JpaRepository<Country, Integer> {

}
