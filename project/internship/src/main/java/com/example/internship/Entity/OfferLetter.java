package com.example.internship.Entity;

import java.time.LocalDate;

public class OfferLetter {
    public int id;
    public int companyId;
    public int studentId;
    public String subject;
    public String description;
    public LocalDate sendingDate;

    public OfferLetter(int id, int companyId, int studentId, String subject, String description) {
        this.id = id;
        this.companyId = companyId;
        this.studentId = studentId;
        this.subject = subject;
        this.description = description;
        this.sendingDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(LocalDate sendingDate) {
        this.sendingDate = sendingDate;
    }
}
