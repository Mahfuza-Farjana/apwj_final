package com.Project.LibraryManagement.Entity;

import jakarta.validation.constraints.NotNull;

public class Book {
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private Integer quantity;

    private Boolean isAvailable;

    private Integer categoryId;


    public Book() {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
        this.categoryId = categoryId;
    }



    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Boolean getIsAvailable()
    {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }
}