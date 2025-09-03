package com.example.internship.Entity;

import java.time.LocalDate;

public class Internship {
    public int id;
    public String title;
    public int companyId;
    public int categoryId;
    public String description;
    public LocalDate deadline;
    public boolean active;
    public LocalDate postedDate;

    public Internship(int id, String title, int companyId, int categoryId, String description, LocalDate deadline, boolean active, LocalDate postedDate) {
        this.id = id;
        this.title = title;
        this.companyId = companyId;
        this.categoryId = categoryId;
        this.description = description;
        this.deadline = deadline;
        this.active = active;
        this.postedDate = postedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }
}
