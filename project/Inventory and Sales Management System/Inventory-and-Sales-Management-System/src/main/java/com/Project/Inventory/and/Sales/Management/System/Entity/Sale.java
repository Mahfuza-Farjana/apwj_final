package com.Project.Inventory.and.Sales.Management.System.Entity;

import java.time.LocalDateTime;

public class Sale {
    private Integer id;
    private Integer customerId;
    private Integer discountId; // Optional
    private Double totalAmount;
    private LocalDateTime saleDate;

    public Sale() {
    }

    public Sale(Integer id, Integer customerId, Integer discountId, Double totalAmount, LocalDateTime saleDate) {
        this.id = id;
        this.customerId = customerId;
        this.discountId = discountId;
        this.totalAmount = totalAmount;
        this.saleDate = saleDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }
}
