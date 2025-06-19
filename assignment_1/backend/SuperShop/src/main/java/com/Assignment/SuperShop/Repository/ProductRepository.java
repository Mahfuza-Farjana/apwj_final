package com.Assignment.SuperShop.Repository;

import com.Assignment.SuperShop.Entity.Product;
import com.Assignment.SuperShop.ProductCategory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    public static final List<Product>products = new ArrayList<>();
    static{
        products.add(new Product(1,"Cream", 500,15, LocalDate.of(2026,4,12),ProductCategory.BeautyCare,true));
        products.add(new Product(2,"Sunscreen", 800,12, LocalDate.of(2026,6,8),ProductCategory.BeautyCare,true));
        products.add(new Product(3,"Potato", 50,18, LocalDate.of(2025,7,27),ProductCategory.Vegetables,true));
        products.add(new Product(4,"Carrot", 40,12, LocalDate.of(2025,7,25),ProductCategory.Vegetables,true));
        products.add(new Product(5,"Chicken", 350,10, LocalDate.of(2025,7,29),ProductCategory.Meat,true));
        products.add(new Product(6,"Beef", 700,14, LocalDate.of(2025,8,12),ProductCategory.Meat,true));
        products.add(new Product(7,"Rice", 50,25, LocalDate.of(2025,9,18),ProductCategory.Groceries,true));
        products.add(new Product(8,"Salt", 40,15, LocalDate.of(2026,4,13),ProductCategory.Groceries,true));
        products.add(new Product(9,"Light", 500,10, LocalDate.of(2027,5,12),ProductCategory.Others,true));
        products.add(new Product(10,"Fan", 5000,15, LocalDate.of(2028,7,12),ProductCategory.Others,true));
    }

    public List<Product> getALLProducts()
    {
        return products;
    }

    public Product getByProductId(int ID)
    {
        return products.stream().filter(product -> product.getID() == ID).findFirst().orElse(null);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    public void UpdateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == product.getID()) {
                products.set(i, product);
                break;
            }
        }
    }



    public void DeleteByProductId(int ID) {
        products.removeIf(product -> product.getID() == ID);
    }

    public List<Product> getByProductsCategory(ProductCategory category) {
        return products.stream().filter(product -> product.getProductCategory() == category).toList();
    }

    public List<Product> getExpiringIn7Days() {
        LocalDate today = LocalDate.now();
        LocalDate in7Days = today.plusDays(7);
        return products.stream()
                .filter(p -> p.getExpiryDate() != null &&
                        !p.getExpiryDate().isBefore(today) &&
                        !p.getExpiryDate().isAfter(in7Days))
                .toList();
    }

    public List<Product> getByProductsAvailability(boolean isAvailable) {
        return products.stream().filter(product -> product.isAvailablity() == isAvailable).toList();
    }

    public List<Product> getDiscountedProducts(ProductCategory category, double rate) {
        return products.stream()
                .filter(p -> p.getProductCategory() == category)
                .map(p -> new Product(
                        p.getID(),
                        p.getName(),
                        p.getPrice() * (1 -(rate / 100)),
                        p.getQuantity(),
                        p.getExpiryDate(),
                        p.getProductCategory(),
                        p.isAvailablity()
                ))
                .collect(Collectors.toList());
    }


    public void markExpiredProductsUnavailable() {
        LocalDate today = LocalDate.now();
        products.forEach(p -> {
            if (p.getExpiryDate() != null && p.getExpiryDate().isBefore(today)) {
                p.setAvailablity(false);
            }
        });
    }

    public Map<ProductCategory, Double> getTotalValueGroupedByCategory() {
        return products.stream()
                .filter(Product::isAvailablity)
                .collect(Collectors.groupingBy(
                        Product::getProductCategory,
                        Collectors.summingDouble(p -> p.getPrice() * p.getQuantity())
                ));
    }


}



