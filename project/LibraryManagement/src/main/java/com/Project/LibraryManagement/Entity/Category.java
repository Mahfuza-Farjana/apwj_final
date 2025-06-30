package com.Project.LibraryManagement.Entity;

import jakarta.validation.constraints.NotNull;

public class Category {
    private Integer id;

    @NotNull
    private String name;


    public Category() {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
