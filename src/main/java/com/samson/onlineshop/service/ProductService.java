package com.samson.onlineshop.service;

import com.samson.onlineshop.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProducts();
    void updateAllStock();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Product getProductById(String productId);

    void addProduct(Product product);
}
