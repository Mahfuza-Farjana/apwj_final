package com.Project.LibraryManagement.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Wishlist {
    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer bookId;

    private LocalDateTime createdAt;



    public Wishlist(Integer id, Integer userId, Integer bookId, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
