package com.example.internship.Service;

import com.example.internship.Entity.Application;
import com.example.internship.Repository.ApplicationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    public ApplicationRepo applicationRepo;

    public ApplicationService(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    public List<Application> getApplicationsByStudent(int studentId) {
        return applicationRepo.getByStudentId(studentId);
    }

    public List<Application> getApplicationsByInternship(int internshipId) {
        return applicationRepo.getByInternshipId(internshipId);
    }

    public void applyForInternship(Application application) {
        applicationRepo.insert(application);
    }

    public void updateApplicationStatus(int applicationId, int statusId) {
        applicationRepo.updateStatus(applicationId, statusId);
    }

    public int countAcceptedApplicationsByCompany(int companyId, int acceptedStatusId) {
        return applicationRepo.countAcceptedApplicationsByCompany(companyId, acceptedStatusId);
    }
}
