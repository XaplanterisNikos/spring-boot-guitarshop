package com.xaplanterisnikos.guitarshop.config;

import com.xaplanterisnikos.guitarshop.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Configuration class for customizing Spring Data REST.
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    /**
     * Constructor to initialize MyDataRestConfig with an EntityManager.
     *
     * @param theEntityManager The EntityManager to be used.
     */
    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    /**
     * Configure the repository REST configuration.
     * This method disables certain HTTP methods (POST, PUT, DELETE) for specified domain types
     * to make them read-only and exposes the IDs of the entities.
     *
     * @param config the repository REST configuration
     * @param cors   the CORS registry
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        // Read-Only
        HttpMethod[] theUnsupportedActions= { HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
        // disable HTTP methods
        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(Product.class), theUnsupportedActions);
        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(ProductCategory.class), theUnsupportedActions);
        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(Country.class), theUnsupportedActions);
        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(State.class), theUnsupportedActions);
        disableHttpMethods(config.getExposureConfiguration()
                .forDomainType(Order.class), theUnsupportedActions);


        // call an internal helper method
        exposeIds(config);
    }

    /**
     * Disable the specified HTTP methods for the given domain type.
     *
     * @param config            the exposure configuration for a domain type
     * @param theUnsupportedActions the HTTP methods to be disabled
     */
    private static void disableHttpMethods(ExposureConfigurer config, HttpMethod[] theUnsupportedActions) {
        config
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    /**
     * Expose the IDs of the entities in the repository response.
     *
     * @param config the repository REST configuration
     */
    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity ids

        // list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // get the entity types for the entities
        for(EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // expose the entity ids for the array of entity types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }



}
