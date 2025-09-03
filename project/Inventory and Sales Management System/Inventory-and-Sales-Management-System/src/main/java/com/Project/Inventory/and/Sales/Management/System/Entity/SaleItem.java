package com.Project.Inventory.and.Sales.Management.System.Entity;

import jakarta.validation.constraints.NotNull;

public class SaleItem {

    private Integer id;

    @NotNull
    private Integer saleId;

    @NotNull
    private Integer productId;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double price;


    public SaleItem() {}

    public SaleItem(Integer id, Integer saleId, Integer productId, Integer quantity, Double price) {
        this.id = id;
        this.saleId = saleId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
