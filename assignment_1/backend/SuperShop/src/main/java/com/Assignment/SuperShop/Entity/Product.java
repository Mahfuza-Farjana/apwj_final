package com.Assignment.SuperShop.Entity;

import com.Assignment.SuperShop.ProductCategory;

import java.time.LocalDate;

public class Product {
    private int ID;
    private String Name;
    private double Price;
    private int Quantity;
    private LocalDate ExpiryDate;
    private ProductCategory productCategory;
    private boolean Availablity;

    public Product(int ID, String Name, double Price, int Quantity, LocalDate ExpiryDate, ProductCategory productCategory, boolean Availablity) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.ExpiryDate = ExpiryDate;
        this.productCategory = productCategory;
        this.Availablity = Availablity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
       this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(LocalDate ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public boolean isAvailablity() {
        return Availablity;
    }

    public void setAvailablity(boolean Availablity) {
        this.Availablity = Availablity;
    }
}
