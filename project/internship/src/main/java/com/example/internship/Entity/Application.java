package com.example.internship.Entity;

import java.time.LocalDate;

public class Application {
    public int id;
    public int studentId;
    public int internshipId;
    public int statusId;
    public LocalDate applicationDate;

    public Application(int id, int studentId, int internshipId, int statusId, LocalDate applicationDate) {
        this.id = id;
        this.studentId = studentId;
        this.internshipId = internshipId;
        this.statusId = statusId;
        this.applicationDate = applicationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(int internshipId) {
        this.internshipId = internshipId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }
}
