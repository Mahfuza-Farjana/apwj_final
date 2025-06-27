package com.Project.LibraryManagement.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class User {
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String role;

    public User(){}

    public User(String email, Integer id, String username, String password, String role) {
        this.email = email;
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }




    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
}

