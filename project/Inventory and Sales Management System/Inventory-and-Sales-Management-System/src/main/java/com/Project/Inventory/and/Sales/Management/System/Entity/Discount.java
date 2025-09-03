package com.Project.Inventory.and.Sales.Management.System.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class Discount {

    private Integer id;

    @NotNull
    private Double percentage;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private String description;

    public Discount() {}

    public Discount(Integer id, Double percentage, LocalDate startDate, LocalDate endDate, String description) {
        this.id = id;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
