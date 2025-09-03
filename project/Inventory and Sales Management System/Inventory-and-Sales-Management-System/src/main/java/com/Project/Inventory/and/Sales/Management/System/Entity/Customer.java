package com.Project.Inventory.and.Sales.Management.System.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;



public class Customer {

    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    public Customer() {}

    public Customer(String email, Integer id, String username, String password, Role role) {
        this.email = email;
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
