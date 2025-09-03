package com.example.internship.Service;

import com.example.internship.Entity.Resume;
import com.example.internship.Repository.ResumeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {
    private final ResumeRepo resumeRepo;

    public ResumeService(ResumeRepo resumeRepo) {
        this.resumeRepo = resumeRepo;
    }

    public List<Resume> getResumesByStudent(int studentId) {
        return resumeRepo.getByStudentId(studentId);
    }

    public List<Resume> getResumesByCompany(int companyId) {
        return resumeRepo.getByCompanyId(companyId);
    }

    public void addResume(Resume resume) {
        resumeRepo.insert(resume);
    }

    public void updateResume(Resume resume) {
        resumeRepo.update(resume);
    }

    public void deleteResume(int id) {
        resumeRepo.delete(id);
    }
}
