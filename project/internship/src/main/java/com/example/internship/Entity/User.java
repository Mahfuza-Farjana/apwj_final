package com.example.internship.Entity;

import java.time.LocalDate;

public class User {
    public int id;
    public String email;
    public String password;
    public int roleId;
    public boolean approved;
    public LocalDate createDate;

    public User(int id, String email, String password, int roleId, boolean approved) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.approved = approved;
        this.createDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

}
