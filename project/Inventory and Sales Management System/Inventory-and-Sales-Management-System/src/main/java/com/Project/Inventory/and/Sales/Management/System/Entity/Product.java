package com.Project.Inventory.and.Sales.Management.System.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class Product {

    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Integer categoryId;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    private LocalDate expiryDate;

    private Boolean isAvailable;

    public Product() {}


    public Product(Integer id, String name, Integer categoryId, Double price, Integer quantity, LocalDate expiryDate, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.isAvailable = isAvailable;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
