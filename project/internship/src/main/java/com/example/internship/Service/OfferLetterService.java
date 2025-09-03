package com.example.internship.Service;

import com.example.internship.Entity.OfferLetter;
import com.example.internship.Repository.OfferLetterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferLetterService {
    public OfferLetterRepo offerLetterRepo;

    public OfferLetterService(OfferLetterRepo offerLetterRepo) {
        this.offerLetterRepo = offerLetterRepo;
    }

    public List<OfferLetter> getOfferLettersByStudent(int studentId) {
        return offerLetterRepo.getByStudentId(studentId);
    }

    public List<OfferLetter> getOfferLettersByCompany(int companyId) {
        return offerLetterRepo.getByCompanyId(companyId);
    }

    public void sendOfferLetter(OfferLetter offerLetter) {
        offerLetterRepo.insert(offerLetter);
    }
}
