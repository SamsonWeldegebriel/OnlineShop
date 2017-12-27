package com.samson.onlineshop.service;

import com.samson.onlineshop.domain.Product;
import com.samson.onlineshop.repository.ProductRepository;
import com.samson.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public void updateAllStock() {
        List<Product> allProducts = (List<Product>) productRepository.findAll();
        for (Product product : allProducts) {
            if (product.getUnitsInStock() < 500) {
                //productRepository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
                product.setUnitsInStock(product.getUnitsInStock() + 1000);
                productRepository.save(product);
            }
        }
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findProductsByCategory(category);
    }

    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {

        //return productRepository.getProductsByCategoryAndManufacturer(filterParams);
        return productRepository.findProductsByCategory(filterParams);
    }

    public Product getProductById(String productId) {
        return productRepository.findProductsByProductId(productId);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}

