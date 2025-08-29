package com.Assignment.ShopManagement.entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class Product {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private LocalDate expiryDate;
    @NotNull
    private Integer quantity;
    @NotNull
    private Category category;

    public Product() {
    }

    public Product(Integer id, String name, Double price, LocalDate expiryDate, Integer quantity, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
