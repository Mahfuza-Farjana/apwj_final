package com.Assignment.SuperShop.Api;

import com.Assignment.SuperShop.Entity.Product;
import com.Assignment.SuperShop.ProductCategory;
import com.Assignment.SuperShop.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/product")
@CrossOrigin
public class ProductApi {
    public ProductService productService;


    public ProductApi(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }


    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/category")
    public List<Product> getByCategory(@RequestParam ProductCategory category) {
        return productService.getProductsByCategory(category);
    }


    @GetMapping("/expiring-soon")
    public List<Product> getExpiringProductsIn7Days() {
        return productService.getExpiringProductsIn7Days();
    }


    @GetMapping("/availability")
    public List<Product> getProductsByAvailability(@RequestParam boolean available) {
        return productService.getProductsByAvailability(available);
    }


    @GetMapping("/discount")
    public List<Product> getDiscountedProducts(@RequestParam ProductCategory category,
                                               @RequestParam double rate) {
        return productService.getDiscountedProducts(category, rate);
    }


    @PutMapping("/mark-expired")
    public void markExpiredProductsUnavailable() {
        productService.markExpiredProductsUnavailable();
    }


    @GetMapping("/total-value")
    public Map<ProductCategory, Double> getTotalValueByCategory() {
        return productService.getTotalValueGroupedByCategory();
    }
}
