package com.example.internship.Entity;

import java.time.LocalDateTime;

public class Resume {
    public int id;
    public int studentId;
    public int companyId;
    public String resumeLocation;
    public LocalDateTime uploadedDate;

    public Resume(int id, int studentId, int companyId, String resumeLocation) {
        this.id = id;
        this.studentId = studentId;
        this.companyId = companyId;
        this.resumeLocation = resumeLocation;
        this.uploadedDate = LocalDateTime.now();
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getResumeLocation() {
        return resumeLocation;
    }

    public void setResumeLocation(String resumeLocation) {
        this.resumeLocation = resumeLocation;
    }

    public LocalDateTime getUploadedDate() {
        return uploadedDate;
    }

}
