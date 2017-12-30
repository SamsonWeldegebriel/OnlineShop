package com.samson.onlineshop.repository;

import com.samson.onlineshop.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends CrudRepository<Product, String> {
    //List<Product> getAllProducts();
    //void updateStock(String productId, long noOfUnits);

    List<Product> findProductsByCategory(String category);

//    List<Product> findProductsByCategory(Map<String, List<String>> filterParams);

//   @Query("SELECT p FROM PRODUCTS p WHERE CATEGORY IN (:categories) AND MANUFACTURER IN (:brands)")
//    List<Product> getProductsByCategoryAndManufacturer(Map<String, List<String>> filterParams);

    List<Product> findProductsByCategoryInAndManufacturerIn(List<String> categories, List<String> manufacturers);

    Product findProductsByProductId(String productId);
}
