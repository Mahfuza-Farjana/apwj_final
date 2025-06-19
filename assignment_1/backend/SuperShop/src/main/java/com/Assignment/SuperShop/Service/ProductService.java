package com.Assignment.SuperShop.Service;

import com.Assignment.SuperShop.Entity.Product;
import com.Assignment.SuperShop.ProductCategory;
import com.Assignment.SuperShop.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getALLProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getByProductId(id);
    }

    public void addProduct(Product product) {
        productRepository.AddProduct(product);
    }

    public void updateProduct(Product product) {
        productRepository.UpdateProduct(product);
    }

    public void deleteProductById(int id) {
        productRepository.DeleteByProductId(id);
    }

    public List<Product> getProductsByCategory(ProductCategory category) {
        return productRepository.getByProductsCategory(category);
    }

    public List<Product> getExpiringProductsIn7Days() {
        return productRepository.getExpiringIn7Days();
    }

    public List<Product> getProductsByAvailability(boolean isAvailable) {
        return productRepository.getByProductsAvailability(isAvailable);
    }

    public List<Product> getDiscountedProducts(ProductCategory category, double discountRate) {
        return productRepository.getDiscountedProducts(category, discountRate);
    }

    public void markExpiredProductsUnavailable() {
        productRepository.markExpiredProductsUnavailable();
    }

    public Map<ProductCategory, Double> getTotalValueGroupedByCategory() {
        return productRepository.getTotalValueGroupedByCategory();
    }
}

