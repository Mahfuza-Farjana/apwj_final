package com.Project.Inventory.and.Sales.Management.System.Entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PasswordResetToken {
    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private String resetToken;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime expiresAt;


    public PasswordResetToken() {
    }

    public PasswordResetToken(Integer id, Integer userId, String resetToken, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.id = id;
        this.userId = userId;
        this.resetToken = resetToken;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
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

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
