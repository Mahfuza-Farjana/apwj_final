package com.Project.LibraryManagement.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CartItem {
    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer bookId;

    private LocalDateTime addedAt;



    public CartItem(Integer id, Integer userId, Integer bookId, LocalDateTime addedAt) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.addedAt = addedAt;
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

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
