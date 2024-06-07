package com.xaplanterisnikos.guitarshop.dao;

import com.xaplanterisnikos.guitarshop.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * Repository interface for managing product categories in the guitar shop application.
 */
//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory",path ="product-category")
public interface ProductCategoryRepositoryDAO extends CrudRepository<ProductCategory, Long> {
}
