package com.example.internship.Entity;

public class CompanyProfile {
    public int id;
    public int userId;
    public String name;
    public String industry;
    public String website;
    public String contactPerson;
    public String location;
    public String phoneNo;

    public CompanyProfile(int id, int userId, String name, String industry, String website, String contactPerson, String location, String phoneNo) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.industry = industry;
        this.website = website;
        this.contactPerson = contactPerson;
        this.location = location;
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
