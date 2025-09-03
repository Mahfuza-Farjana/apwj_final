package com.example.internship.Entity;

public class StudentProfile {
    public int id;
    public int userId;
    public String name;
    public String university;
    public String major;
    public int passingYear;

    public StudentProfile(int id, int userId, String name, String university, String major, int passingYear) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.university = university;
        this.major = major;
        this.passingYear = passingYear;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }
}
