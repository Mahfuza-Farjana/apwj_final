package com.Project.LibraryManagement.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Reservation {
    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer bookId;

    private LocalDateTime reservedAt;

    private String status;

    public Reservation() {}

    public Reservation(Integer id, Integer userId, Integer bookId, LocalDateTime reservedAt, String status) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.reservedAt = reservedAt;
        this.status = status;
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

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
