package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.Product;
import com.Project.Inventory.and.Sales.Management.System.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    // Get product by id
    public Product getProductById(int id) {
        return productRepository.getById(id);
    }

    // Create new product with validation and availability logic
    public void createProduct(Product product) {
        validateProduct(product);
        updateAvailability(product);
        productRepository.save(product);
    }

    // Update product with validation and availability logic
    public void updateProduct(Product product) {
        validateProduct(product);
        updateAvailability(product);
        productRepository.update(product);
    }

    // Delete product by id
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    // Get products with low stock threshold
    public List<Product> getLowStockProducts(int threshold) {
        return productRepository.getLowStock(threshold);
    }

    // Private helper to validate product fields
    private void validateProduct(Product product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (product.getCategoryId() == null) {
            throw new IllegalArgumentException("Product must have a category.");
        }
        if (product.getPrice() == null || product.getPrice() < 0) {
            throw new IllegalArgumentException("Product price must be non-negative.");
        }
        if (product.getQuantity() == null || product.getQuantity() < 0) {
            throw new IllegalArgumentException("Product quantity must be non-negative.");
        }
        // Optionally, check expiryDate if set
        if (product.getExpiryDate() != null && product.getExpiryDate().isBefore(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Product expiry date cannot be in the past.");
        }
    }

    // Private helper to update availability based on quantity
    private void updateAvailability(Product product) {
        product.setAvailable(product.getQuantity() > 0);
    }
}
