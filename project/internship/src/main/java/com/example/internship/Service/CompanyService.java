package com.example.internship.Service;

import com.example.internship.Entity.CompanyProfile;
import com.example.internship.Repository.CompanyProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    public CompanyProfileRepo companyProfileRepo;

    public CompanyService(CompanyProfileRepo companyProfileRepo) {
        this.companyProfileRepo = companyProfileRepo;
    }

    public CompanyProfile getProfileByUserId(int userId) {
        return companyProfileRepo.getByUserId(userId);
    }

    public void updateProfile(CompanyProfile companyProfile) {
        companyProfileRepo.update(companyProfile);
    }
}
