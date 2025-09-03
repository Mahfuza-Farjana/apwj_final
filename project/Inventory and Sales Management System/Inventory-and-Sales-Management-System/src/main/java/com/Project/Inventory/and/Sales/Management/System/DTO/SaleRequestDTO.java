package com.Project.Inventory.and.Sales.Management.System.DTO;

import com.Project.Inventory.and.Sales.Management.System.Entity.SaleItem;

import java.time.LocalDateTime;
import java.util.List;

public class SaleRequestDTO {
    private Integer customerId;
    private List<SaleItem> items;
    private Integer discountId;
    private LocalDateTime saleDate;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }
}
